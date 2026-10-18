package io.github.mikeandike08.taper.service;
import org.springframework.stereotype.Service;
import io.github.mikeandike08.taper.model.Barber;
import java.util.List;

@Service
public class BarberService {
    private final List<Barber> barbers = List.of(
        new Barber("Test barber", "something@gmail.com", "203-342-1934", "Fake", "State")
    );

    public List<Barber> getAllBarbers(){
        return barbers;
    }
}
