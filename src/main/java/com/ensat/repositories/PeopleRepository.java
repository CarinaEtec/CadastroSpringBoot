package com.ensat.repositories;

import com.ensat.entities.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People, Integer> {

}
