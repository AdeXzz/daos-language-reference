package com.innovyze.aquaservice.platform.u202311334.emergency.interfaces.rest;

import com.innovyze.aquaservice.platform.u202311334.emergency.infrastructure.persistence.jpa.repositories.EvacuationOrderRepository;
import com.innovyze.aquaservice.platform.u202311334.emergency.interfaces.resources.EvacuationOrderResource;
import com.innovyze.aquaservice.platform.u202311334.emergency.interfaces.transform.EvacuationOrderResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/evacuation-orders")
@Tag(name = "Evacuation Orders", description = "Operations for viewing issued evacuation orders")
public class EvacuationOrdersController {

    private final EvacuationOrderRepository repository;

    public EvacuationOrdersController(EvacuationOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @Operation(
            summary = "Get all evacuation orders",
            description = "Retrieves all evacuation orders with full metadata including audit fields"
    )
    @ApiResponse(responseCode = "200", description = "Evacuation orders retrieved successfully")
    public List<EvacuationOrderResource> getAllEvacuationOrders() {
        return repository.findAll()
                .stream()
                .map(EvacuationOrderResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
    }
}
