package com.vkspark.vkspark_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vkspark.vkspark_backend.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Search by Movie Name

    List<Movie> findByMovieNameContainingIgnoreCase(String movieName);

    // Filter by Language

    List<Movie> findByLanguageIgnoreCase(String language);

    // Filter by Genre

    List<Movie> findByGenreIgnoreCase(String genre);

    // Language + Genre

    List<Movie> findByLanguageIgnoreCaseAndGenreIgnoreCase(
            String language,
            String genre
    );

    
}