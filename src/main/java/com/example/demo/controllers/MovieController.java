package com.example.demo.controllers;

import com.example.demo.CustomizedResponse;
import com.example.demo.models.Movie;
import com.example.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController

public class MovieController {

    @Autowired
    private MovieService service;
@GetMapping("/movies")
//return any type
public ResponseEntity getMovies(){
    var customizedResponse = new CustomizedResponse("A list of movies", service.getMovies());
    return new ResponseEntity(customizedResponse, HttpStatus.OK);
}
@GetMapping("/tvs")
public ResponseEntity getTvs(){
    var customizedResponse = new CustomizedResponse("A list of tvs", service.getTvs());
    return new ResponseEntity(customizedResponse, HttpStatus.OK);
}
    @GetMapping("/featuredMovies")
    public ResponseEntity getFeaturedMovies() {
        var customizedResponse = new CustomizedResponse("get Featured Movies", service.getFeaturedMovies());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/featuredTvs")
    public ResponseEntity getFeaturedTvs() {
        var customizedResponse = new CustomizedResponse("get Featured Tvs", service.getFeaturedTvs());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    @PostMapping(value= "/movies", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){

        Movie newMovie = service.insertIntoMovies(movie);
        return new ResponseEntity(newMovie, HttpStatus.OK);

    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getAMovie(@PathVariable Integer id) {
        CustomizedResponse customizedResponse = null;
        try{
            customizedResponse = new CustomizedResponse("Movie with ID: "+id, Collections.singletonList(service.getAMovie(id)));
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);

            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
       // return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity searchByTitle(@PathVariable String title) {
        CustomizedResponse customizedResponse;
        try {
            customizedResponse = new CustomizedResponse("get movie/show by title", Collections.singletonList(service.searchByTitle(title)));
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/movie/{id}") // Ensure the mapping starts with a '/'
    public ResponseEntity updateMovie(@PathVariable Integer id, @RequestBody Movie updatedInfo) {
        try {
            Movie updatedMovie = service.updateMovie(id, updatedInfo);
            CustomizedResponse customizedResponse = new CustomizedResponse("Successfully updated movie/TV with ID: " + id, Collections.singletonList(updatedMovie));
            return new ResponseEntity<>(customizedResponse, HttpStatus.OK);
        }  catch (Exception e) {
            CustomizedResponse customizedResponse = new CustomizedResponse("An unexpected error occurred.", null);
            return new ResponseEntity<>(customizedResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<CustomizedResponse> deleteAMovie(@PathVariable("id") Integer id) {
        try {
            service.deleteAMovie(id);
            CustomizedResponse customizedResponse = new CustomizedResponse("Movie/TV with ID: " + id + " successfully deleted", null);
            return new ResponseEntity(customizedResponse, HttpStatus.OK);
        } catch (Exception e) {
            CustomizedResponse customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND);
        }
    }

}
