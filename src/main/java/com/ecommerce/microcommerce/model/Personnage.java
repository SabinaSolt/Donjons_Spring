package com.ecommerce.microcommerce.model;

import java.util.ArrayList;

public class Personnage {

        protected ArrayList<Hero> personnages;

        //constructor method
        public Personnage() {
            this.personnages=new ArrayList();
            for (int i = 0; i < 5; i++) {
                int chance=(int) (Math.random() * 2);
                String type=(chance==0)?"Guerrier":"Magicien";
                String name=type+"_"+i;
                personnages.add(new Hero(i,name,type));
            }
        }

        public ArrayList getPersonnages() {
            return personnages;
        }

        public void setPersonnages(ArrayList personnages) {
            this.personnages = personnages;
        }

        public Hero getHero(int id) {
            return personnages.get(id);
        }
        @Override
        public String toString() {
            return "Personnages{" +
                    "personnages=" + personnages +
                    '}';
        }
    }


