package com.app.multipledbreader.service;

import com.app.multipledbreader.persistence.h2.model.Person;
import com.app.multipledbreader.persistence.h2.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public void save(Person person){
        personRepository.save(person);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Optional<Person> getByName(String name) {
        return personRepository.findByName(name);
    }
}
