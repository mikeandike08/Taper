package io.github.mikeandike08.taper.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.mikeandike08.taper.model.Barber;

public interface BarberRepository extends JpaRepository<Barber, Long> {
}
