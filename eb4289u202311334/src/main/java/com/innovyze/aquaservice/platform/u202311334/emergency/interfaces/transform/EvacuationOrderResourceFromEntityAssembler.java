package com.innovyze.aquaservice.platform.u202311334.emergency.interfaces.transform;

import com.innovyze.aquaservice.platform.u202311334.emergency.domain.aggregates.EvacuationOrder;
import com.innovyze.aquaservice.platform.u202311334.emergency.interfaces.resources.EvacuationOrderResource;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class EvacuationOrderResourceFromEntityAssembler {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static EvacuationOrderResource toResourceFromEntity(EvacuationOrder order) {
        return new EvacuationOrderResource(
                order.getId(),
                order.getAssetCode().toString(),
                order.getAffectedZones(),
                order.getReason(),
                order.getPriority().name(),
                formatter.format(order.getIssuedAt()),
                order.getState().name(),
                formatter.format(order.getValidUntil()),
                formatter.format(order.getCreatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                formatter.format(order.getUpdatedAt().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
        );
    }
}