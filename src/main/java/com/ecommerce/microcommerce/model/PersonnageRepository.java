package com.ecommerce.microcommerce.model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnageRepository extends CrudRepository<Personnage, Integer>{
}
