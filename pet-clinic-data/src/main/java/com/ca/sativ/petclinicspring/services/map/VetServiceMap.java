package com.ca.sativ.petclinicspring.services.map;

import com.ca.sativ.petclinicspring.model.Vet;
import com.ca.sativ.petclinicspring.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
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
