package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Movie;
import com.vkspark.vkspark_backend.repository.MovieRepository;
import com.vkspark.vkspark_backend.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {

        Optional<Movie> movie = movieRepository.findById(id);

        if (movie.isPresent()) {
            return movie.get();
        }

        throw new RuntimeException("Movie not found with id: " + id);
    }
    @Override
public Movie updateMovie(Long id, Movie updatedMovie) {

    Movie movie = getMovieById(id);

    movie.setMovieName(updatedMovie.getMovieName());
    movie.setDescription(updatedMovie.getDescription());
    movie.setDuration(updatedMovie.getDuration());
    movie.setLanguage(updatedMovie.getLanguage());
    movie.setGenre(updatedMovie.getGenre());
    movie.setPosterUrl(updatedMovie.getPosterUrl());
    movie.setReleaseDate(updatedMovie.getReleaseDate());

    return movieRepository.save(movie);
}
@Override
public void deleteMovie(Long id) {

    Movie movie = getMovieById(id);

    movieRepository.delete(movie);
}
}