package io.github.mikeandike08.taper.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikeandike08.taper.dto.BarberSummary;
import io.github.mikeandike08.taper.dto.ListResponse;
import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.model.PageResult;
import io.github.mikeandike08.taper.service.BarberService;

@RestController
@RequestMapping("/barbers")
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
    @GetMapping
    public ListResponse<BarberSummary> getAllBarbers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){
        
        size = Math.min(size, 100); // Limit the size to 100

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
}
