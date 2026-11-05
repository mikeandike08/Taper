package io.github.mikeandike08.taper.service;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.model.PageResult;

@Service
public class BarberService {
    private final List<Barber> barbers = List.of(
        new Barber("Test barber", "Test shop", "something@gmail.com", "203-342-1934", "Fake", "State", 0)
    );

    public PageResult<Barber> getBarbers(int page, int size){
        // Filter the list
        // TODO: Implement filtering logic here
       
        // Record the total
        long total = barbers.size();

        // Calculate the offset
        int fromIndex = Math.min(page * size, barbers.size());

        int toIndex = Math.min(fromIndex + size, barbers.size());

        // Return a sublist of the filtered list, with the total
        return new PageResult<>(barbers.subList(fromIndex, toIndex), total);
    }
}
