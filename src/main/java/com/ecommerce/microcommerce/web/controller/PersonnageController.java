package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.PersonnageDao;
import com.ecommerce.microcommerce.model.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@Api( "API pour es opérations CRUD sur les produits.")
@RestController
public class PersonnageController {

    @Autowired
    private PersonnageDao personnageDao;

    @GetMapping("/Personnages")
    public List<Personnage> listePersonnages() {
        return personnageDao.findAll();
    }
    @GetMapping(value = "/Personnages/{id}")
    public Personnage displayPersonnage(@PathVariable int id) {
        return personnageDao.findById(id);
    }
    @PostMapping(value="/Personnages")
    public ResponseEntity<Void> addPersonnage(@RequestBody Personnage personnage) {
       Personnage personnageAdded= personnageDao.save(personnage);

        if (personnageAdded == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(personnageAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
    @PutMapping(value="/Personnages/{id}")
    public void updatePersonnage(@RequestBody Personnage personnage,@PathVariable int id) {
         personnageDao.update(personnage,id);
    }
    @DeleteMapping(value = "/Personnages/{id}")
    public void deletePersonnage(@PathVariable int id) {
        personnageDao.delete(id);
    }
}

