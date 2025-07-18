package com.innovyze.aquaservice.platform.u202311334.risks.infrastructure.persistence.jpa.repositories;

import com.innovyze.aquaservice.platform.u202311334.risks.domain.aggregates.RiskParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiskParameterRepository extends JpaRepository<RiskParameter, Long> {

    Optional<RiskParameter> findByInfrastructureTypeAndFailureType(String infrastructureType, String failureType);
}
