package io.github.mikeandike08.taper.service;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mikeandike08.taper.model.Barber;

@Service
public class BarberService {
    private final List<Barber> barbers = List.of(
        new Barber("Test barber", "Test shop", "something@gmail.com", "203-342-1934", "Fake", "State")
    );

    public List<Barber> getAllBarbers(int page, int size){
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, barbers.size());
        return barbers.subList(fromIndex, toIndex);
    }
}
