package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Personnage;
import java.util.List;

public interface PersonnageDao {
    public List<Personnage> findAll();
    public Personnage findById(int id);
    public Personnage save(Personnage personnage);
    public Personnage update(Personnage personnage, int id);
    public Boolean delete(int id);
}
