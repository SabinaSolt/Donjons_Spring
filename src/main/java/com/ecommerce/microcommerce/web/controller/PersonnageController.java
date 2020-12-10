package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.PersonnageDao;
import com.ecommerce.microcommerce.model.*;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Api( "API pour es opérations CRUD sur les produits.")
@RestController
public class PersonnageController {

    @Autowired
    private PersonnageDao personnageDao;

    @GetMapping("/Personnages")
    public PersonList listePersonnages() {
        PersonList personList=new PersonList();
        personList.setPersonList(personnageDao.findAll());
        return personList;

    }
    @GetMapping(value = "/Personnages/{id}")
    public Personnage  displayPersonnage(@PathVariable int id) {
        Personnage personnage= personnageDao.findById(id);
        /*if(personnage==null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();*/
        return personnage;
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
    public ResponseEntity<Void> updatePersonnage(@RequestBody Personnage personnage,@PathVariable int id) {
         Personnage personnageUpdated=personnageDao.update(personnage,id);
         if(personnageUpdated==null) {
             return ResponseEntity.noContent().build();
         }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/Personnages/{id}")
    public ResponseEntity<Void> deletePersonnage(@PathVariable int id) {
        Boolean isDeleted=personnageDao.delete(id);
        if(!isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }
}

