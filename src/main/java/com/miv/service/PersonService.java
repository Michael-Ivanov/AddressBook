package com.miv.service;

import com.miv.entity.Person;
import com.miv.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    private PersonRepository repo;

    @Autowired
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person getById(int id) {
        return repo.getOne(id);
    }

    public Person savePerson(Person person) {
        return repo.save(person);
    }
}
