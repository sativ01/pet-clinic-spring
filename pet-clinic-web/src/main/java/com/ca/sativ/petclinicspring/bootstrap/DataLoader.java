package com.ca.sativ.petclinicspring.bootstrap;

import com.ca.sativ.petclinicspring.model.Owner;
import com.ca.sativ.petclinicspring.model.Vet;
import com.ca.sativ.petclinicspring.services.OwnerService;
import com.ca.sativ.petclinicspring.services.VetService;
import com.ca.sativ.petclinicspring.services.map.OwnerServiceMap;
import com.ca.sativ.petclinicspring.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("alice");
        owner1.setLastName("anderson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("bob");
        owner2.setLastName("brandon");

        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("zak");
        vet1.setLastName("zapper");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("yan");
        vet2.setLastName("yovovic");

        vetService.save(vet2);

        System.out.println("Loaded vets ...");
    }
}
