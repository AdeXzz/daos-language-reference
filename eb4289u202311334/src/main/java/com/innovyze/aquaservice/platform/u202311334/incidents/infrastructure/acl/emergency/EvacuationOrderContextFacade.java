package com.innovyze.aquaservice.platform.u202311334.incidents.infrastructure.acl.emergency;

import com.innovyze.aquaservice.platform.u202311334.emergency.domain.valueobjects.EvacuationOrderPriority;
import com.innovyze.aquaservice.platform.u202311334.emergency.domain.valueobjects.EvacuationOrderState;
import com.innovyze.aquaservice.platform.u202311334.emergency.domain.aggregates.EvacuationOrder;
import com.innovyze.aquaservice.platform.u202311334.emergency.infrastructure.persistence.jpa.repositories.EvacuationOrderRepository;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.events.IncidentEvaluatedEvent;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.AssetCode;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EvacuationOrderContextFacade {

    private final EvacuationOrderRepository evacuationOrderRepository;

    public EvacuationOrderContextFacade(EvacuationOrderRepository evacuationOrderRepository) {
        this.evacuationOrderRepository = evacuationOrderRepository;
    }

    @EventListener
    public void onIncidentEvaluated(IncidentEvaluatedEvent event) {
        double percentageExcess = (event.impactValue() - getThreshold(event)) / getThreshold(event);

        EvacuationOrderPriority priority;
        int hoursUntilExpiration;

        if (percentageExcess > 0.15) {
            priority = EvacuationOrderPriority.URGENT;
            hoursUntilExpiration = 72;
        } else if (percentageExcess > 0.05) {
            priority = EvacuationOrderPriority.HIGH;
            hoursUntilExpiration = 48;
        } else {
            priority = EvacuationOrderPriority.MEDIUM;
            hoursUntilExpiration = 24;
        }

        LocalDateTime now = LocalDateTime.now();

        EvacuationOrder order = new EvacuationOrder(
                event.assetCode(),
                generateZones(event.impactValue()),
                buildReason(event.failureType(), event.impactValue()),
                priority,
                now,
                EvacuationOrderState.ISSUED,
                now.plusHours(hoursUntilExpiration)
        );

        evacuationOrderRepository.save(order);
    }

    private double getThreshold(IncidentEvaluatedEvent event) {
        return event.impactValue() / 1.10;
    }

    private String buildReason(String failureType, double impactValue) {
        return "Failure of type '%s' detected with impact %.2f.".formatted(failureType, impactValue);
    }

    private List<String> generateZones(double impactValue) {
        if (impactValue > 150) {
            return List.of("Zone A", "Zone B", "Zone C");
        } else if (impactValue > 75) {
            return List.of("Zone A", "Zone B");
        } else {
            return List.of("Zone A");
        }
    }
}
