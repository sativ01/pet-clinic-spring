package com.ca.sativ.petclinicspring.services.map;

import com.ca.sativ.petclinicspring.model.Owner;
import com.ca.sativ.petclinicspring.model.Pet;
import com.ca.sativ.petclinicspring.model.PetType;
import com.ca.sativ.petclinicspring.services.OwnerService;
import com.ca.sativ.petclinicspring.services.PetService;
import com.ca.sativ.petclinicspring.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            Set<Pet> pets = object.getPets();
            if (!pets.isEmpty()) {
                pets.forEach(pet -> {
                    PetType petType = pet.getPetType();
                    if (petType != null) {
                        // if this is a new petType that's not yet in the DB
                        // then we need to save it in the petTypeService
                        if (petType.getId() == null) {
                            pet.setPetType(petTypeService.save(petType));
                        }
                    } else {
                        throw new RuntimeException("Pet is required to have a PetType");
                    }

                    // If the pet is not in DB yet, we need to store her
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        // TODO: implement it
        return null;
    }
}
