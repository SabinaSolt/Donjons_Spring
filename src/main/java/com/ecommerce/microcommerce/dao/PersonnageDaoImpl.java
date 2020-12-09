package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Personnage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonnageDaoImpl implements PersonnageDao{
    public static List<Personnage> personnages=new ArrayList<>();
    static {
        personnages.add(new Personnage(1, new String("La cobaye sanguinaire"), "Guerrier"));
        personnages.add(new Personnage(2, new String("Harry Potelé"), "Magicien"));
        personnages.add(new Personnage(3, new String("Le moissonneur d`âmes"), "Guerrier"));
    }


    @Override
    public List<Personnage> findAll() {
        return personnages;
    }

    @Override
    public Personnage findById(int id) {
        for (Personnage personnage : personnages) {
            if(personnage.getId() ==id){
                return personnage;
            }
        }
        return null;
    }

    @Override
    public Personnage save(Personnage personnage) {

        Personnage persoExist= personnages.stream()
                .filter(p->p.getId()== personnage.getId())
                .findFirst().orElse(null);

        if(persoExist==null) {
            personnages.add(personnage);
            return personnage;
        }
        return null;
    }

    @Override
    public Personnage update(Personnage personnage, int id) {
        for(int i=0; i< personnages.size();i++) {
            Personnage p=personnages.get(i);
            if(p.getId()==id) {
                personnages.set(i,personnage);
                return personnages.get(i);
            }
        }
        return null;
    }

    @Override
    public Boolean delete(int id) {
       return personnages.removeIf(p->p.getId()==id);
    }
}
