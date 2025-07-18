package com.innovyze.aquaservice.platform.u202311334.emergency.interfaces.resources;

import java.util.List;

public record EvacuationOrderResource(
        Long id,
        String assetCode,
        List<String> affectedZones,
        String reason,
        String priority,
        String issuedAt,
        String state,
        String validUntil,
        String createdAt,
        String updatedAt
) {}
