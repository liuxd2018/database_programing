package com.example.demo.repositories;

import com.example.demo.model.Pet;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// simple repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    @Query("select * from pet where name = :name")
    List<Pet> findByName(@Param("name") String name);
}
