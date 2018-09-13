package com.ca.sativ.petclinicspring.services;

import com.ca.sativ.petclinicspring.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
