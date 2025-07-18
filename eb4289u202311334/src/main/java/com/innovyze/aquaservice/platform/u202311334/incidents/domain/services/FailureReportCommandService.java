package com.innovyze.aquaservice.platform.u202311334.incidents.domain.services;

import com.innovyze.aquaservice.platform.u202311334.incidents.domain.aggregates.FailureReport;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.commands.CreateFailureReportCommand;

public interface FailureReportCommandService {
    FailureReport handle(CreateFailureReportCommand command);
}
