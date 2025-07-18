package com.innovyze.aquaservice.platform.u202311334.incidents.domain.commands;

import java.time.LocalDateTime;

public record CreateFailureReportCommand(
        String assetCode,
        String infrastructureType,
        String failureType,
        Double reportedImpactValue,
        LocalDateTime reportedAt,
        LocalDateTime resolvedAt
) {}
