package com.innovyze.aquaservice.platform.u202311334.incidents.infrastructure.persistence.jpa.repositories;

import com.innovyze.aquaservice.platform.u202311334.incidents.domain.aggregates.FailureReport;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.valueobjects.AssetCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FailureReportRepository extends JpaRepository<FailureReport, Long> {

    boolean existsByAssetCodeAndFailureTypeAndReportedAtBetween(
            AssetCode assetCode,
            String failureType,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay
    );
}
