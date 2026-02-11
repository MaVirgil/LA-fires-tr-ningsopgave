package org.mavirgil.lafires.service;

import org.mavirgil.lafires.model.Siren;
import org.mavirgil.lafires.repository.SirenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SirenService {

    private final SirenRepository repository;

    public SirenService(SirenRepository repository) {
        this.repository = repository;
    }

    public boolean exists(Integer id) {
        return repository.existsById(id);
    }

    public List<Siren> getAll() {
        return repository.findAll();
    }

    public Siren getById(Integer id) {
        Optional<Siren> found = repository.findById(id);

        if (found.isEmpty()) {
            throw new IllegalArgumentException("Siren not found");
        }

        return found.get();
    }

    public Siren add(Siren siren) {
        return repository.save(siren);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
