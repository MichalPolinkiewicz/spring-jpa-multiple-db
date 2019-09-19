package com.app.multipledbreader.repository;

import com.app.multipledbreader.config.H2Config;
import com.app.multipledbreader.persistence.h2.model.Person;
import com.app.multipledbreader.persistence.h2.repository.PersonRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {H2Config.class})
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void cleanDB(){
       personRepository.deleteAll();
    }

    @Test
    @Transactional(transactionManager = "h2TransactionManager")
    public void shouldSavePerson(){
        Person person = new Person();
        person.setName("Janusz");
        personRepository.save(person);

        assertEquals(personRepository.findAll().size(), 1);
    }

    @Test
    public void shouldFind(){
        Person person = new Person();
        person.setName("Janusz");
        personRepository.save(person);

        Optional<Person> result = personRepository.findByName("Janusz");

        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), "Janusz");
        assertEquals(result.get().getId(), person.getId());
    }
}
