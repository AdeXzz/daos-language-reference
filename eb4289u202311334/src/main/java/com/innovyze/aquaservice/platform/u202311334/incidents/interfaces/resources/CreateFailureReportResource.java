package com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.resources;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record CreateFailureReportResource(
        @NotBlank String assetCode,
        @NotBlank String infrastructureType,
        @NotBlank String failureType,
        @NotNull @Positive Double reportedImpactValue,
        @NotNull LocalDateTime reportedAt,
        LocalDateTime resolvedAt
) {}
