package org.mavirgil.lafires.controller;

import org.mavirgil.lafires.model.Siren;
import org.mavirgil.lafires.repository.SirenRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siren")
public class SirenController {

    private final SirenRepository repository;

    public SirenController(SirenRepository repository) {
        this.repository = repository;
    }

    /*
    ----------------------------------
            GET ENDPOINTS
    -----------------------------------
    */

    @GetMapping
    public ResponseEntity<List<Siren>> getSirens() {

        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    /*
    ----------------------------------
                POST ENDPOINTS
    -----------------------------------
    */

    @PostMapping
    public ResponseEntity<Siren> addSiren(@RequestBody Siren siren) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(siren));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    /*
    ----------------------------------
                PUT ENDPOINTS
    -----------------------------------
    */

    @PutMapping("/{id}")
    public ResponseEntity<Siren> editSiren(@PathVariable Integer id, @RequestBody Siren siren) {

        try {
            siren.setId(id);
            return ResponseEntity.ok(repository.save(siren));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    /*
    ----------------------------------
                DELETE ENDPOINTS
    -----------------------------------
    */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSiren(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
