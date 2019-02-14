package com.ca.sativ.petclinicspring.bootstrap;

import com.ca.sativ.petclinicspring.model.Owner;
import com.ca.sativ.petclinicspring.model.Pet;
import com.ca.sativ.petclinicspring.model.PetType;
import com.ca.sativ.petclinicspring.model.Vet;
import com.ca.sativ.petclinicspring.services.OwnerService;
import com.ca.sativ.petclinicspring.services.PetTypeService;
import com.ca.sativ.petclinicspring.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

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
        owner2.setFirstName("bob");
        owner2.setLastName("brandon");
        owner2.setAddress("Big City", "Short Street 1", "321-321-321");
        Pet o2Cat1 = new Pet("Gill", catType);
        owner2.addPet(o2Cat1);

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("zak");
        vet1.setLastName("zapper");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("yan");
        vet2.setLastName("yovovic");

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}
