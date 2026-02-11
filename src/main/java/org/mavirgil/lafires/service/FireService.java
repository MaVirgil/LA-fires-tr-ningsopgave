package org.mavirgil.lafires.service;

import org.mavirgil.lafires.model.Fire;
import org.mavirgil.lafires.repository.FireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireService {

    private final FireRepository fireRepository;

    public FireService(FireRepository fireRepository) {
        this.fireRepository = fireRepository;
    }

    public boolean exists(Integer id) {
        return fireRepository.existsById(id);
    }

    public List<Fire> getAll() {
        return fireRepository.findAll();
    }

    public Fire getById(Integer id) {
        Optional<Fire> found = fireRepository.findById(id);

        if (found.isEmpty()) {
            throw new IllegalArgumentException("Fire not found!");
        }

        return found.get();
    }

    public Fire add(Fire fire) {
        return fireRepository.save(fire);
    }

    public void delete(Integer id) {
        fireRepository.deleteById(id);
    }
}
