package com.ca.sativ.petclinicspring.services;

import com.ca.sativ.petclinicspring.model.Speciality;

public interface SpecialityService extends CrudService<Speciality, Long> {
    Speciality findByName(String speciality);
}
