package com.innovyze.aquaservice.platform.u202311334.incidents.domain.events;

import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.AssetCode;

public record IncidentEvaluatedEvent(
        AssetCode assetCode,
        String failureType,
        String infrastructureType,
        double impactValue,
        java.time.LocalDateTime evaluatedAt
) {}
