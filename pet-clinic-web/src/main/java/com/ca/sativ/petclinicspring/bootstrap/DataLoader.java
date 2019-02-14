package com.ca.sativ.petclinicspring.bootstrap;

import com.ca.sativ.petclinicspring.model.*;
import com.ca.sativ.petclinicspring.services.OwnerService;
import com.ca.sativ.petclinicspring.services.PetTypeService;
import com.ca.sativ.petclinicspring.services.SpecialityService;
import com.ca.sativ.petclinicspring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().isEmpty()){
            loadData();
        }
    }

    private void loadData() {
        Speciality radiology = new Speciality("Radiology");
        Speciality surgery = new Speciality("Surgery");
        Speciality dentistry = new Speciality("Dentistry");

        specialityService.save(radiology);
        specialityService.save(surgery);
        specialityService.save(dentistry);

        PetType dogType = new PetType("dog");
        PetType catType = new PetType("cat");
        PetType hamster = new PetType("hamster");

        petTypeService.save(dogType);
        petTypeService.save(catType);
        petTypeService.save(hamster);

        System.out.println("Loaded pet types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("alice");
        owner1.setLastName("anderson");
        owner1.setAddress("Big City", "Long Street 1", "123-123-123");

        Pet o1Dog1 = new Pet("Bill", dogType);
        owner1.addPet(o1Dog1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Brandon");
        owner2.setAddress("Big City", "Short Street 1", "321-321-321");
        Pet o2Cat1 = new Pet("Gill", catType);
        owner2.addPet(o2Cat1);

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Zak");
        vet1.setLastName("Zapper");
        vet1.addSpeciality(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Yan");
        vet2.setLastName("Yovovic");
        vet2.addSpeciality(surgery);

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}
