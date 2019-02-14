package com.ca.sativ.petclinicspring.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

    private Address address;
    private Set<Pet> pets;

    public Owner() {
        super();
        this.pets = new HashSet<>();
    }

    public Owner(Set<Pet> pets) {
        super();
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        pets.forEach(pet -> {
            pet.setOwner(this);
        });
        this.pets = pets;
    }

    public void addPet(Pet pet){
        pet.setOwner(this);
        this.pets.add(pet);
    }

    public void addPets(Set<Pet> pets){
        pets.forEach(pet -> {pet.setOwner(this);});
        this.pets.addAll(pets);
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String city, String street, String telephone) {
        Address address = new Address();
        address.setAddress(street);
        address.setCity(city);
        address.setTelephone(telephone);

        this.address = address;
    }

}
