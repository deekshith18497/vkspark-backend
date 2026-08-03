package com.vkspark.vkspark_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;
import com.vkspark.vkspark_backend.entity.Movie;

public interface MovieService {

    Movie addMovie(Movie movie);

    Movie updateMovie(Long id, Movie movie);

    void deleteMovie(Long id);

    Movie getMovieById(Long id);

    Page<Movie> getAllMovies(Pageable pageable);

    List<Movie> searchMovie(String keyword);

List<Movie> getMoviesByLanguage(String language);

List<Movie> getMoviesByGenre(String genre);

List<Movie> getMoviesByLanguageAndGenre(
        String language,
        String genre);
}