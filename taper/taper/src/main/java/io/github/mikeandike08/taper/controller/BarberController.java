package io.github.mikeandike08.taper.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.mikeandike08.taper.service.BarberService;
import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.controller.ListResponse;
import java.util.List;

@RestController
@RequestMapping("/barbers")
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService){
        this.barberService = barberService;
    }

    @GetMapping
    public ListResponse<Barber> getAllBarbers(){
        // Get our list of barbers
        List<Barber> barbers = barberService.getAllBarbers();

        // Create a ListResponse, so it has the key "items"
        ListResponse<Barber> response = new ListResponse<>(barbers);
        return response;
    }
}
