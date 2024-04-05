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

    @Query("SELECT m FROM Movie m WHERE m.isMovie = true AND m.isFeatured = true")
    List<Movie> findFeaturedMovie();
    @Query("SELECT m FROM Movie m WHERE m.isMovie = false AND m.isFeatured = true")
    List<Movie> findFeaturedTvs();
}
