package com.innovyze.aquaservice.platform.u202311334.risks.domain.aggregates;

import com.innovyze.aquaservice.platform.u202311334.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "risk_parameters")
@Getter
@NoArgsConstructor
public class RiskParameter extends AuditableAbstractAggregateRoot<RiskParameter> {

    @Column(nullable = false)
    private String infrastructureType;

    @Column(nullable = false)
    private String failureType;

    @Column(nullable = false)
    private Double minImpactValue;

    @Column(nullable = false)
    private Double maxImpactValue;

    @Column(nullable = false)
    private Double severityThreshold;

    public RiskParameter(String infrastructureType, String failureType,
                         Double minImpactValue, Double maxImpactValue, Double severityThreshold) {
        this.infrastructureType = infrastructureType;
        this.failureType = failureType;
        this.minImpactValue = minImpactValue;
        this.maxImpactValue = maxImpactValue;
        this.severityThreshold = severityThreshold;
    }
}
