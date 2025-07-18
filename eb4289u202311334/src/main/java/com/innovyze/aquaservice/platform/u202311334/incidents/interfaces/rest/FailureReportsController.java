package com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.rest;

import com.innovyze.aquaservice.platform.u202311334.incidents.application.internal.commandservices.FailureReportCommandServiceImpl;
import com.innovyze.aquaservice.platform.u202311334.incidents.domain.commands.CreateFailureReportCommand;
import com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.resources.CreateFailureReportResource;
import com.innovyze.aquaservice.platform.u202311334.incidents.interfaces.transform.FailureReportResourceFromEntityAssembler;
import com.innovyze.aquaservice.platform.u202311334.shared.resources.MessageResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/failure-reports")
@Tag(name = "Failure Reports", description = "Operations related to reporting infrastructure failures")
public class FailureReportsController {

    private final FailureReportCommandServiceImpl service;

    public FailureReportsController(FailureReportCommandServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
            summary = "Register a new failure report",
            description = "Creates a failure report and evaluates it against risk parameters. May trigger evacuation."
    )
    @ApiResponse(responseCode = "201", description = "Failure report created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input or business rule violation")
    public ResponseEntity<?> createFailureReport(@Valid @RequestBody CreateFailureReportResource resource) {
        try {
            var command = new CreateFailureReportCommand(
                    resource.assetCode(),
                    resource.infrastructureType(),
                    resource.failureType(),
                    resource.reportedImpactValue(),
                    resource.reportedAt(),
                    resource.resolvedAt()
            );

            var saved = service.handle(command);
            var response = FailureReportResourceFromEntityAssembler.toResourceFromEntity(saved);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(new MessageResource(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
