package com.ensat.services;

import com.ensat.entities.People;
import com.ensat.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {

    private PeopleRepository peopleRepository;

    @Autowired
    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public Iterable<People> listAllPeoples() {
        return peopleRepository.findAll();
    }

    @Override
    public People getPeopleById(Integer id) {
        return peopleRepository.findOne(id);
    }

    @Override
    public People savePeople(People people) {
        return peopleRepository.save(people);
    }

    @Override
    public void deletePeople(Integer id) {
        peopleRepository.delete(id);
    }

}
