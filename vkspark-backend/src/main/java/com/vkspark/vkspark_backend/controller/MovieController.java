package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Movie;
import com.vkspark.vkspark_backend.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}