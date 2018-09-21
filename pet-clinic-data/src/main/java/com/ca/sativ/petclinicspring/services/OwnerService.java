package com.ca.sativ.petclinicspring.services;

import com.ca.sativ.petclinicspring.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
