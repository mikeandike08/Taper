package io.github.mikeandike08.taper.config;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.mikeandike08.taper.model.Barber;
import io.github.mikeandike08.taper.repository.BarberRepository;

@Component 
public class DataSeeder implements CommandLineRunner {
    private final BarberRepository barberRepository;

    public DataSeeder(BarberRepository barberRepository) {
        this.barberRepository = barberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only seed an empty database; otherwise every restart duplicates data
        if (barberRepository.count() > 0) {
            return;
        }

        Barber marcus = new Barber("Marcus Reed", "Fresh Cuts", "marcus@example.com", "555-0101",
                "12 Bank St", "Waterbury", "CT", "06702", "Fades and tapers, 10 years in the chair.");
        marcus.setStyles(Set.of("fade", "taper", "lineup"));

        Barber elena = new Barber("Elena Cruz", "Curl Theory", "elena@example.com", "555-0102",
                "88 Chapel St", "New Haven", "CT", "06510", "Curly hair specialist. Dry cuts only.");
        elena.setStyles(Set.of("curly", "scissor"));

        Barber dre = new Barber("Andre Wallace", "The Chair", "dre@example.com", "555-0103",
                "301 Main St", "Hartford", "CT", "06103", "Clean fades and beard work.");
        dre.setStyles(Set.of("fade", "beard"));

        Barber kai = new Barber("Kai Nguyen", "Studio K", "kai@example.com", "555-0104",
                "45 Grand St", "Waterbury", "CT", "06702", "Textured cuts, wolf cuts, and perms.");
        kai.setStyles(Set.of("wolf cut", "perm", "scissor"));

        Barber sofia = new Barber("Sofia Marino", "Marino's", "sofia@example.com", "555-0105",
                "19 Elm St", "New Haven", "CT", "06511", "Classic scissor cuts and tapers.");
        sofia.setStyles(Set.of("scissor", "taper"));

        Barber jay = new Barber("Jay Thompson", "Blade Room", "jay@example.com", "555-0106",
                "7 West Main St", "Hartford", "CT", "06105", "Skin fades and designs.");
        jay.setStyles(Set.of("fade", "design", "lineup"));

        // No styles yet, to see how an empty set looks in the JSON
        Barber nina = new Barber("Nina Patel", "Fresh Start", "nina@example.com", "555-0107",
                "230 Meriden Rd", "Waterbury", "CT", "06705", "Just opened, booking now.");

        barberRepository.saveAll(List.of(marcus, elena, dre, kai, sofia, jay, nina));
    }
}
