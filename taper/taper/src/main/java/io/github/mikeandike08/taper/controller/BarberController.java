package io.github.mikeandike08.taper.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.mikeandike08.taper.service.BarberService;
import io.github.mikeandike08.taper.model.Barber;
import java.util.List;

@RestController
@RequestMapping("/barbers")
public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService){
        this.barberService = barberService;
    }

    @GetMapping
    public List<Barber> getAllBarbers(){
        return barberService.getAllBarbers();
    }
}
