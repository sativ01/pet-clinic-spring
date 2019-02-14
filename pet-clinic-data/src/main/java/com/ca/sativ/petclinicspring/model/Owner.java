package com.ca.sativ.petclinicspring.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    public Owner() {
        this.pets = new HashSet<>();
    }

    public Owner(Set<Pet> pets) {
        this.pets = pets;
    }

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){
        this.pets.add(pet);
    }

    public void addPets(Set<Pet> pets){
        this.pets.addAll(pets);
    }

}
