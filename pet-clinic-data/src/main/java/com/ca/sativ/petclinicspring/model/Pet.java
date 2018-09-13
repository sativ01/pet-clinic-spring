package com.ca.sativ.petclinicspring.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{
    private  PetType perType;
    private Owner owner;
    private LocalDate bithDate;

    public PetType getPerType() {
        return perType;
    }

    public void setPerType(PetType perType) {
        this.perType = perType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBithDate() {
        return bithDate;
    }

    public void setBithDate(LocalDate bithDate) {
        this.bithDate = bithDate;
    }
}
