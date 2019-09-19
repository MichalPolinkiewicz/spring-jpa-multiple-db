package com.app.multipledbreader.repository;

import com.app.multipledbreader.config.MySqlConfig;
import com.app.multipledbreader.persistence.mysql.model.Dog;
import com.app.multipledbreader.persistence.mysql.repository.DogRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MySqlConfig.class})
public class DogRepositoryTest {

    @Autowired
    private DogRepository dogRepository;

    @Before
    public void cleanDB(){
        dogRepository.deleteAll();
    }

    @Test
    @Transactional(transactionManager = "mysqlTransactionManager")
    public void shouldSaveDog() {
        Dog dog = new Dog();
        dog.setName("Zuza");
        dogRepository.save(dog);

        assertEquals(dogRepository.findAll().size(), 1);
    }

    @Test
    public void shouldFind(){
        Dog dog = new Dog();
        dog.setName("Zuza");
        dogRepository.save(dog);

        Optional<Dog> result = dogRepository.findByName("Zuza");
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), dog.getId());
        assertEquals(result.get().getName(), dog.getName());
    }
}
