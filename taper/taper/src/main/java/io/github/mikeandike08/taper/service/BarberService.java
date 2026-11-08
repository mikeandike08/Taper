package io.github.mikeandike08.taper.service;
import org.springframework.stereotype.Service;

import io.github.mikeandike08.taper.exceptions.InvalidParameterException;
import io.github.mikeandike08.taper.exceptions.ResourceNotFoundException;
import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.model.PageResult;
import io.github.mikeandike08.taper.repository.BarberRepository;

@Service
public class BarberService {
    private final BarberRepository barberRepository;

    public BarberService(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    public PageResult<Barber> getBarbers(int page, int size){
        // Validate the parameters
        if (page < 0)
            throw new InvalidParameterException("Page must be greater than 0");
        if (size <= 0)
            throw new InvalidParameterException("Size must be greater than 0");
        
        // Filter the list
        // TODO: Implement filtering logic here
       
        // Record the total
        long total = barberRepository.count();

        // Calculate the offset
        int fromIndex = Math.min(page * size, (int) total);

        int toIndex = Math.min(fromIndex + size, (int) total);

        // Return a sublist of the filtered list, with the total
        return new PageResult<>(barberRepository.findAll().subList(fromIndex, toIndex), total);
    }

    public Barber getBarberById(Long id) {
    return barberRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Barber with id " + id + " not found"));
    }
}