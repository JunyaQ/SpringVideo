package com.example.demo.models;

import com.example.demo.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends MongoRepository<Movie, String> {
List<Movie> findByTitleContainingIgnoreCase(String title);
}
