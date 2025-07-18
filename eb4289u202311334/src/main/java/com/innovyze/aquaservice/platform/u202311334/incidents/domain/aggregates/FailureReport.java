package com.innovyze.aquaservice.platform.u202311334.incidents.domain.aggregates;

import com.innovyze.aquaservice.platform.u202311334.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.AssetCode;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.FailureReportState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "failure_reports")
@Getter
@NoArgsConstructor
public class FailureReport extends AuditableAbstractAggregateRoot<FailureReport> {

    @Embedded
    private AssetCode assetCode;

    @Column(nullable = false)
    private String infrastructureType;

    @Column(nullable = false)
    private String failureType;

    @Column(nullable = false)
    private Double reportedImpactValue;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private FailureReportState state = FailureReportState.PENDING;

    @Column(nullable = false)
    private LocalDateTime reportedAt;

    private LocalDateTime resolvedAt;

    public FailureReport(AssetCode assetCode, String infrastructureType, String failureType,
                         Double reportedImpactValue, LocalDateTime reportedAt) {
        this.assetCode = assetCode;
        this.infrastructureType = infrastructureType;
        this.failureType = failureType;
        this.reportedImpactValue = reportedImpactValue;
        this.reportedAt = reportedAt;
        this.state = FailureReportState.PENDING;
    }

    public void flag() {
        this.state = FailureReportState.FLAGGED;
    }

    public void accept() {
        this.state = FailureReportState.ACCEPTED;
    }

    public void evaluate() {
        this.state = FailureReportState.EVALUATED;
    }

    public void resolve(LocalDateTime resolvedAt) {
        if (resolvedAt != null && resolvedAt.isBefore(reportedAt)) {
            throw new IllegalArgumentException("Resolved date cannot be before reported date.");
        }
        this.resolvedAt = resolvedAt;
        this.state = FailureReportState.RESOLVED;
    }
}