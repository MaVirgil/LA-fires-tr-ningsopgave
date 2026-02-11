package org.mavirgil.lafires.config;

import org.mavirgil.lafires.model.Location;
import org.mavirgil.lafires.model.Siren;
import org.mavirgil.lafires.repository.FireRepository;
import org.mavirgil.lafires.repository.SirenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private final FireRepository fireRepository;

    private final SirenRepository sirenRepository;

    public InitData(FireRepository fireRepository, SirenRepository sirenRepository) {
        this.fireRepository = fireRepository;
        this.sirenRepository = sirenRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Siren siren1 = new Siren();
        siren1.setLocation(new Location(34.05445870594, -118.31551290499135));

        Siren siren2 = new Siren();
        siren2.setLocation(new Location(33.944158298155045, -118.19361623929149));

        Siren siren3 = new Siren();
        siren3.setLocation(new Location(34.18809678582704, -118.4361232858282));

        sirenRepository.saveAll(List.of(siren1, siren2, siren3));

        System.out.println("Saved sirens to database...");
    }
}
