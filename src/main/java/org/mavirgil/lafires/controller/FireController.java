package org.mavirgil.lafires.controller;

import org.mavirgil.lafires.model.Fire;
import org.mavirgil.lafires.model.Siren;
import org.mavirgil.lafires.repository.FireRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fire")
public class FireController {

    private final FireRepository repository;

    public FireController(FireRepository repository) {
        this.repository = repository;
    }

    /*----------------------------------
                GET ENDPOINTS
    -----------------------------------*/

    @GetMapping
    public ResponseEntity<List<Fire>> getFires() {

        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /*----------------------------------
                POST ENDPOINTS
    -----------------------------------*/
    @PostMapping
    public ResponseEntity<Fire> addFire(@RequestBody Fire fire) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(fire));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /*----------------------------------
                PUT ENDPOINTS
    -----------------------------------*/
    @PutMapping("/{id}")
    public ResponseEntity<Fire> editFire(@PathVariable Integer id, @RequestBody Fire fire) {

        try {
            fire.setId(id);
            return ResponseEntity.ok(repository.save(fire));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    /*----------------------------------
                DELETE ENDPOINTS
    -----------------------------------*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFire(@PathVariable Integer id) {

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
