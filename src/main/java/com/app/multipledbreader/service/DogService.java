package com.app.multipledbreader.service;

import com.app.multipledbreader.persistence.mysql.model.Dog;
import com.app.multipledbreader.persistence.mysql.repository.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DogService {

    @Autowired
    private final DogRepository dogRepository;

    public void save(Dog dog) {
        dogRepository.save(dog);
    }

    public List<Dog> getAll(){
        return dogRepository.findAll();
    }

    public Optional<Dog> getByName(String name) {
        return dogRepository.findByName(name);
    }
}
