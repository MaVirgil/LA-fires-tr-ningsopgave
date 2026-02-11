package org.mavirgil.lafires.controller;

import org.mavirgil.lafires.model.Siren;
import org.mavirgil.lafires.repository.SirenRepository;
import org.mavirgil.lafires.service.SirenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siren")
public class SirenController {

    private final SirenService sirenService;

    public SirenController(SirenService sirenService) {
        this.sirenService = sirenService;
    }

    /*----------------------------------
            GET ENDPOINTS
    -----------------------------------*/

    @GetMapping
    public ResponseEntity<List<Siren>> getSirens() {

        try {
            return ResponseEntity.ok(sirenService.getAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siren> getSirenById(@PathVariable Integer id) {

        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(sirenService.getById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    /*----------------------------------
                POST ENDPOINTS
    -----------------------------------*/

    @PostMapping
    public ResponseEntity<Siren> addSiren(@RequestBody Siren siren) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(sirenService.add(siren));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    /*----------------------------------
                PUT ENDPOINTS
    -----------------------------------*/

    @PutMapping("/{id}")
    public ResponseEntity<Siren> editSiren(@PathVariable Integer id, @RequestBody Siren siren) {

        try {
            siren.setId(id);
            return ResponseEntity.ok(sirenService.add(siren));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    /*----------------------------------
                DELETE ENDPOINTS
    -----------------------------------*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSiren(@PathVariable Integer id) {

        if (!sirenService.exists(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            sirenService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
