package com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.transform;

import com.innovyze.aquaservice.platform.u202311334.incidents.domain.aggregates.FailureReport;
import com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.resources.FailureReportResource;

import java.time.format.DateTimeFormatter;

public class FailureReportResourceFromEntityAssembler {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static FailureReportResource toResourceFromEntity(FailureReport report) {
        return new FailureReportResource(
                report.getId(),
                report.getAssetCode().toString(),
                report.getInfrastructureType(),
                report.getFailureType(),
                report.getReportedImpactValue(),
                report.getState().name(),
                formatter.format(report.getReportedAt()),
                report.getResolvedAt() != null ? formatter.format(report.getResolvedAt()) : null
        );
    }
}
