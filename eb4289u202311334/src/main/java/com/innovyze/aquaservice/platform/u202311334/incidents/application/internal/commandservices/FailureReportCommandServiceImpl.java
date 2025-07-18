package com.innovyze.aquaservice.platform.u202311334.incidents.application.internal.commandservices;

import com.innovyze.aquaservice.platform.u202311334.emergency.infrastructure.persistence.jpa.repositories.EvacuationOrderRepository;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.aggregates.FailureReport;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.commands.CreateFailureReportCommand;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.events.IncidentEvaluatedEvent;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.services.FailureReportCommandService;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.AssetCode;
import com.innovyze.aquaservice.platform.u202311334.incidents.infrastructure.acl.emergency.EvacuationOrderContextFacade;
import com.innovyze.aquaservice.platform.u202311334.incidents.infrastructure.persistence.jpa.repositories.FailureReportRepository;
import com.innovyze.aquaservice.platform.u202311334.risks.domain.aggregates.RiskParameter;
import com.innovyze.aquaservice.platform.u202311334.risks.infrastructure.persistence.jpa.repositories.RiskParameterRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FailureReportCommandServiceImpl implements FailureReportCommandService {

    private final FailureReportRepository failureReportRepository;
    private final RiskParameterRepository riskParameterRepository;
    private final EvacuationOrderContextFacade evacuationOrderContextFacade;

    public FailureReportCommandServiceImpl(
            FailureReportRepository failureReportRepository,
            RiskParameterRepository riskParameterRepository,
            EvacuationOrderContextFacade evacuationOrderContextFacade) {
        this.failureReportRepository = failureReportRepository;
        this.riskParameterRepository = riskParameterRepository;
        this.evacuationOrderContextFacade = evacuationOrderContextFacade;
    }

    @Override

    public FailureReport handle(CreateFailureReportCommand command) {
        AssetCode assetCode = AssetCode.from(command.assetCode());

        if (command.reportedImpactValue() <= 0)
            throw new IllegalArgumentException("Reported impact value must be positive.");

        if (command.reportedAt() == null || command.reportedAt().isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Reported date cannot be null or in the future.");

        if (command.resolvedAt() != null && command.resolvedAt().isBefore(command.reportedAt()))
            throw new IllegalArgumentException("Resolved date cannot be before reported date.");

        boolean existsToday = failureReportRepository.existsByAssetCodeAndFailureTypeAndReportedAtBetween(
                assetCode,
                command.failureType(),
                command.reportedAt().toLocalDate().atStartOfDay(),
                command.reportedAt().toLocalDate().atTime(23, 59, 59));

        if (existsToday)
            throw new IllegalArgumentException("A failure report already exists today for this asset and failure type.");

        FailureReport report = new FailureReport(
                assetCode,
                command.infrastructureType(),
                command.failureType(),
                command.reportedImpactValue(),
                command.reportedAt()
        );

        Optional<RiskParameter> risk = riskParameterRepository
                .findByInfrastructureTypeAndFailureType(command.infrastructureType(), command.failureType());

        if (risk.isPresent()) {
            RiskParameter parameter = risk.get();
            double value = command.reportedImpactValue();
            if (value < parameter.getMinImpactValue()
                    || value > parameter.getMaxImpactValue()
                    || value > parameter.getSeverityThreshold()) {
                report.flag();
                report.addDomainEvent(new IncidentEvaluatedEvent(
                        assetCode,
                        command.failureType(),
                        command.infrastructureType(),
                        value,
                        LocalDateTime.now()
                ));
            } else {
                report.accept();
            }
        } else {
            throw new IllegalArgumentException("No risk parameters found for the specified infrastructure and failure type.");
        }

        return failureReportRepository.save(report);
    }
}
