package io.github.mikeandike08.taper.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.service.BarberService;

@RestController
@RequestMapping("/barbers")
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService){
        this.barberService = barberService;
    }

    /**
     * 
     * @param page @defaultValue = 0
     * @param size @defaultValue = 10
     * @return A ListResponse object containing a list of barbers, with the key "items"
     */
    @GetMapping
    public ListResponse<Barber> getAllBarbers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){
        
        size = Math.min(size, 1000); // Limit the size to 1000

        // Get our list of barbers
        List<Barber> barbers = barberService.getAllBarbers(page, size);

        // Create a ListResponse, so it has the key "items"
        ListResponse<Barber> response = new ListResponse<>(barbers);
        return response;
    }
}
