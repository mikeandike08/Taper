package io.github.mikeandike08.taper.controller;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikeandike08.taper.dto.BarberSummary;
import io.github.mikeandike08.taper.dto.ListResponse;
import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.model.PageResult;
import io.github.mikeandike08.taper.service.BarberService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping(value="/barbers", produces=MediaType.APPLICATION_JSON_VALUE) 
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService){
        this.barberService = barberService;
    }

    /**
     * Gets a list of all barbers
     * @param page @defaultValue = 0
     * @param size @defaultValue = 10
     * @return A ListResponse object containing a list of barbers, with the key "items"
     */
    @Operation(
        summary="Gets a list of all barbers",
        description = "Returns barbers sorted by id ascending."
    )
    @GetMapping
    public ListResponse<BarberSummary> getAllBarbers(
        @RequestParam(defaultValue = "0") @Min(0) int page,
        @RequestParam(defaultValue = "10") @Min(1) @Max(100) int size){

        // Get our list of barbers
        PageResult<Barber> barbers = barberService.getBarbers(page, size);

        // Convert to our BarberSummary DTO
        // Takes all Barbers and turn them all into BarberSummary objects,
        // then collect them into a List
        List<BarberSummary> barberSummaries = barbers.items().stream()
            .map(BarberSummary::from)
            .collect(java.util.stream.Collectors.toList());

        // Create a ListResponse, so it has the key "items"
        ListResponse<BarberSummary> response = ListResponse.of(barberSummaries, page, size, barbers.totalItems());
        return response;
    }

    @GetMapping (value="/{id}")
    public BarberSummary getBarberById(@PathVariable Long id){
        Barber barber = barberService.getBarberById(id);
        return BarberSummary.from(barber);
    }
}
