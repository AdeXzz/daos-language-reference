package com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.resources;

public record FailureReportResource(
        Long id,
        String assetCode,
        String infrastructureType,
        String failureType,
        Double reportedImpactValue,
        String state,
        String reportedAt,
        String resolvedAt
) {}
