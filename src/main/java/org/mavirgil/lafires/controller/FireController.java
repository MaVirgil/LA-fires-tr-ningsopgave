package org.mavirgil.lafires.controller;

import org.mavirgil.lafires.repository.FireRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /*----------------------------------
                POST ENDPOINTS
    -----------------------------------*/

    /*----------------------------------
                PUT ENDPOINTS
    -----------------------------------*/

    /*----------------------------------
                DELETE ENDPOINTS
    -----------------------------------*/
}
