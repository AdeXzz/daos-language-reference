package com.innovyze.aquaservice.platform.u202311334.emergency.infrastructure.persistence.jpa.repositories;

import com.innovyze.aquaservice.platform.u202311334.emergency.domain.aggregates.EvacuationOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvacuationOrderRepository extends JpaRepository<EvacuationOrder, Long> {
}
