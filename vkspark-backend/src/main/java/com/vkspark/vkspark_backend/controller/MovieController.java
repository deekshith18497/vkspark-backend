package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Movie;
import com.vkspark.vkspark_backend.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/movies")
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable Long id,
                             @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }
   
    @DeleteMapping("/movies/{id}")
public String deleteMovie(@PathVariable Long id) {

    movieService.deleteMovie(id);

    return "Movie Deleted Successfully";
}
}