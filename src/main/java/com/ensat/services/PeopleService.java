package com.ensat.services;

import com.ensat.entities.People;

public interface PeopleService {

    Iterable<People> listAllPeoples();

    People getPeopleById(Integer id);

    People savePeople(People people);

    void deletePeople(Integer id);

}
