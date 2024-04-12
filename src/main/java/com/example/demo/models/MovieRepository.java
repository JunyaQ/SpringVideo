package com.example.demo.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Integer> {
    List<Movie> findByIsMovieTrue();
    List<Movie> findByIsMovieFalse();

//    Optional<Movie> findById(String id)

//    @Query("SELECT m FROM Movie m WHERE m.featured = true AND m.isMovie = true")
    List<Movie> findByIsMovieTrueAndIsFeaturedTrue();

//    @Query("SELECT m FROM Movie m WHERE m.isMovie = false AND m.isFeatured = true")
    List<Movie> findByIsMovieFalseAndIsFeaturedTrue();
}
