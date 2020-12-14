package com.ecommerce.microcommerce.web.controller;
import com.ecommerce.microcommerce.model.Personnage;
import com.ecommerce.microcommerce.model.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/demo")
public class PersonnageController2 {
    @Autowired
    private PersonnageRepository personnageRepository;

    @PostMapping(path="/add")
    public String addNewPersonnage (@RequestBody Personnage personnage) {
        Personnage p=personnage;
        personnageRepository.save(p);
        return "Saved";
    }

    @GetMapping(path="/all")
    public Iterable<Personnage> getAllPersonnage() {

        return personnageRepository.findAll();
    }

    @GetMapping(path="/all/{id}")
    public Optional<Personnage> getPersonnage(@PathVariable int id) {
       Optional<Personnage> personnage= personnageRepository.findById(id);
       return personnage;
    }

    @PutMapping(path="/update")
    public String updatePersonnage(@RequestBody Personnage personnage) {
        personnageRepository.save(personnage);
        return "Updated";
    }

    @DeleteMapping (path="/delete/{id}")
    public String deletePersonnage(@PathVariable int id) {
        personnageRepository.deleteById(id);
        return "Deleted";
    }
}
