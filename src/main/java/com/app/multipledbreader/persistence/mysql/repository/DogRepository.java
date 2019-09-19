package com.app.multipledbreader.persistence.mysql.repository;

import com.app.multipledbreader.persistence.mysql.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
    Optional<Dog> findByName(String name);
}
