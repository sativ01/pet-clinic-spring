package com.ca.sativ.petclinicspring.services.map;

import com.ca.sativ.petclinicspring.model.Pet;
import com.ca.sativ.petclinicspring.services.PetService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {

    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
