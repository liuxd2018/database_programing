package com.example.demo.repositories;

import com.example.demo.model.Movie;
import org.springframework.data.repository.CrudRepository;

// one-to-one
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
