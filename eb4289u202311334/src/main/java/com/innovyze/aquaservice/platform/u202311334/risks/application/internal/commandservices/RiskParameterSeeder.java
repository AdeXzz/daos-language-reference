package com.innovyze.aquaservice.platform.u202311334.risks.application.internal.commandservices;

import com.innovyze.aquaservice.platform.u202311334.risks.domain.aggregates.RiskParameter;
import com.innovyze.aquaservice.platform.u202311334.risks.infrastructure.persistence.jpa.repositories.RiskParameterRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RiskParameterSeeder {

    private final RiskParameterRepository repository;

    public RiskParameterSeeder(RiskParameterRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void seedData() {
        if (repository.count() == 0) {
            List<RiskParameter> defaults = List.of(
                    new RiskParameter("WATER_PIPE", "burst", 0.0, 100.0, 75.0),
                    new RiskParameter("SEWER_LINE", "overflow", 0.0, 50.0, 40.0),
                    new RiskParameter("PUMPING_STATION", "mechanical_failure", 0.0, 10.0, 8.0),
                    new RiskParameter("RESERVOIR", "structural_crack", 0.0, 200.0, 150.0)
            );

            repository.saveAll(defaults);
        }
    }
}
