package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Movie;
import com.vkspark.vkspark_backend.repository.MovieRepository;
import com.vkspark.vkspark_backend.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
