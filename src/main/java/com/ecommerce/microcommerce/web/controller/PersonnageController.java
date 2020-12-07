package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonnageController {

    Personnage personnages= new Personnage();
    @GetMapping("/Personnages")
    public ArrayList display_personnages() {
        return personnages.getPersonnages();
    }
    @GetMapping(value = "/Personnages/{id}")
    public Hero display_hero(@PathVariable int id) {
        return personnages.getHero(id);
    }
}

