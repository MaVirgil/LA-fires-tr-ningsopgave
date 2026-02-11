package org.mavirgil.lafires.controller;

import org.mavirgil.lafires.model.Siren;
import org.mavirgil.lafires.repository.SirenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/siren")
public class SirenController {

    private SirenRepository repository;

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
        List<Siren> sirens = repository.findAll();

        return ResponseEntity.ok(sirens);
    }

    /*
    ----------------------------------
                POST ENDPOINTS
    -----------------------------------
    */

    /*
    ----------------------------------
                PUT ENDPOINTS
    -----------------------------------
    */

    /*
    ----------------------------------
                DELETE ENDPOINTS
    -----------------------------------
    */
}
