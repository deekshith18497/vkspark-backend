package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

     Movie getMovieById(Long id);
     
     Movie updateMovie(Long id, Movie movie);

     void deleteMovie(Long id);
}
