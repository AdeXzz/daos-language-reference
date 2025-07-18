package com.innovyze.aquaservice.platform.u202311334.emergency.domain.aggregates;

import com.innovyze.aquaservice.platform.u202311334.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.AssetCode;
import com.innovyze.aquaservice.platform.u202311334.emergency.domain.valueobjects.EvacuationOrderPriority;
import com.innovyze.aquaservice.platform.u202311334.emergency.domain.valueobjects.EvacuationOrderState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "evacuation_orders")
@Getter
@NoArgsConstructor
public class EvacuationOrder extends AuditableAbstractAggregateRoot<EvacuationOrder> {

    @Embedded
    private AssetCode assetCode;

    @ElementCollection
    @CollectionTable(name = "evacuation_order_zones", joinColumns = @JoinColumn(name = "evacuation_order_id"))
    @Column(name = "zone", nullable = false)
    private List<String> affectedZones;

    @Column(nullable = false)
    private String reason;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private EvacuationOrderPriority priority;

    @Column(nullable = false)
    private LocalDateTime issuedAt;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private EvacuationOrderState state;

    @Column(nullable = false)
    private LocalDateTime validUntil;

    public EvacuationOrder(AssetCode assetCode, List<String> affectedZones, String reason,
                           EvacuationOrderPriority priority, LocalDateTime issuedAt,
                           EvacuationOrderState state, LocalDateTime validUntil) {
        this.assetCode = assetCode;
        this.affectedZones = affectedZones;
        this.reason = reason;
        this.priority = priority;
        this.issuedAt = issuedAt;
        this.state = state;
        this.validUntil = validUntil;
    }
}
