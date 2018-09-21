package com.ca.sativ.petclinicspring.services;

import com.ca.sativ.petclinicspring.model.Pet;

public interface PetService extends CrudService<Pet, Long> {

    Pet findById(Long id);

}
