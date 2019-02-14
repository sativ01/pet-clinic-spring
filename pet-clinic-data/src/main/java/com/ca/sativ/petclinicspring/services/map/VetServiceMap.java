package com.ca.sativ.petclinicspring.services.map;

import com.ca.sativ.petclinicspring.model.Speciality;
import com.ca.sativ.petclinicspring.model.Vet;
import com.ca.sativ.petclinicspring.services.SpecialityService;
import com.ca.sativ.petclinicspring.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        Set <Speciality> specialities = object.getSpecialities();
        if(! specialities.isEmpty()) {
            specialities.forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality s = specialityService.save(speciality);
                    speciality.setId(s.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {

    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
