package com.vkspark.vkspark_backend.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import java.util.*;
import com.vkspark.vkspark_backend.entity.Movie;
import com.vkspark.vkspark_backend.exception.ResourceNotFoundException;
import com.vkspark.vkspark_backend.repository.MovieRepository;
import com.vkspark.vkspark_backend.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {

        return movieRepository.save(movie);

    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {

        Movie existingMovie =
                movieRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Movie Not Found"));

        existingMovie.setMovieName(movie.getMovieName());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setPosterUrl(movie.getPosterUrl());
        existingMovie.setReleaseDate(movie.getReleaseDate());

        return movieRepository.save(existingMovie);
    }

    @Override
    public void deleteMovie(Long id) {

        Movie movie =
                movieRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Movie Not Found"));

        movieRepository.delete(movie);

    }

    @Override
    public Movie getMovieById(Long id) {

        return movieRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movie Not Found"));

    }

    @Override
    public Page<Movie> getAllMovies(Pageable pageable) {

        return movieRepository.findAll(pageable);

    }

    @Override
public List<Movie> searchMovie(String keyword) {

    return movieRepository
            .findByMovieNameContainingIgnoreCase(keyword);

}

@Override
public List<Movie> getMoviesByLanguage(String language) {

    return movieRepository
            .findByLanguageIgnoreCase(language);

}

@Override
public List<Movie> getMoviesByGenre(String genre) {

    return movieRepository
            .findByGenreIgnoreCase(genre);

}

@Override
public List<Movie> getMoviesByLanguageAndGenre(
        String language,
        String genre) {

    return movieRepository
            .findByLanguageIgnoreCaseAndGenreIgnoreCase(
                    language,
                    genre);

}
}