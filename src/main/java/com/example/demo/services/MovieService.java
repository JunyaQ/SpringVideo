package com.example.demo.services;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieRepository;
import com.example.demo.models.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    // init service as bean
    private MovieRepository repository;
    private SearchRepository searchRepository;
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }
    @Autowired
    public MovieService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }
    // add movie
    public Movie insertIntoMovies(Movie movie){

        //business logic
        return repository.save(movie);

    }
//    get all the movies
    public List<Movie> getMovies(){
//        List<Movie> items = repository.findAll();
        // Filter the list to include only movies
//        System.out.println(repository.findByIsMovieTrue());
        return repository.findByIsMovieTrue();
    }

    //    get all the Tv shows
    public List<Movie> getTvs(){
        return repository.findByIsMovieFalse();
    }

    // featured movie
    public List<Movie> getFeaturedMovies() {

        return repository.findByIsMovieTrueAndIsFeaturedTrue();
    }

    //featured TV
    public List<Movie> getFeaturedTvs(){
        return repository.findByIsMovieFalseAndIsFeaturedTrue();
    }

    // get a movie or tv show based on ID
    public Optional<Movie> getAMovie(Integer id) throws Exception {
        Optional<Movie> movie = repository.findById(id);
        // if movie does not contain value, then
        System.out.println();
        if(!movie.isPresent()){
            throw new Exception("Movie/Tv with "+id+ " is not found");
        }
        return movie;
    }

    //Search via title
    public List<Movie> searchByTitle(String title){
        System.out.println(title);
        return searchRepository.findByTitleContainingIgnoreCase(title);
    }


    // update a movie or tv show based on ID
    public Movie updateMovie(Integer id, Movie updatedMovie) throws Exception {
        Optional<Movie> movieOptional = repository.findById(id);
        if (!movieOptional.isPresent()) {
            throw new Exception("Movie/tv waiting for update with ID: " + id + " not found.");
        }
        Movie movie = movieOptional.get();
        if (updatedMovie.getPrice() != null) {
            movie.setPrice(updatedMovie.getPrice());
        }
        if(updatedMovie.getDescription()!=null){
            movie.setDescription(updatedMovie.getDescription());
        }
        if(updatedMovie.getSmallPoster()!=null){
            movie.setSmallPoster(updatedMovie.getSmallPoster());
        }
        if(updatedMovie.getLargePoster()!=null){
            movie.setLargePoster(updatedMovie.getLargePoster());
        }
        return repository.save(movie);
    }


public void deleteAMovie(Integer id) throws Exception {
    if (!repository.existsById( id)) {
        throw new Exception("Movie with ID: " + id + " not found.");
    }
    repository.deleteById(id);
}

}
