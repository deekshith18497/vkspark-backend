package com.vkspark.vkspark_backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.vkspark.vkspark_backend.entity.Movie;
import com.vkspark.vkspark_backend.service.MovieService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/movies")
@Tag(
        name="Movies",
        description="Movie Management APIs"
)
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @Tag(
        name = "Movies",
        description = "Movie Management APIs"
)
    public Movie addMovie(@RequestBody Movie movie) {

        return movieService.addMovie(movie);

    }

    @PutMapping("/{id}")
    @Tag(
        name = "Movies",
        description = "Movie Management APIs"
)
    public Movie updateMovie(
            @PathVariable Long id,
            @RequestBody Movie movie) {

        return movieService.updateMovie(id, movie);

    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Delete Movie",
        description = "Delete movie by ID"
)
    public String deleteMovie(@PathVariable Long id) {

        movieService.deleteMovie(id);

        return "Movie Deleted Successfully";
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Get Movie",
        description = "Fetch movie using ID"
)
    public Movie getMovieById(@PathVariable Long id) {

        return movieService.getMovieById(id);

    }

    @GetMapping
    public Page<Movie> getAllMovies(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size,

            @RequestParam(defaultValue = "movieName")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction

    ) {

        Sort sort =
                direction.equalsIgnoreCase("desc")
                        ? Sort.by(sortBy).descending()
                        : Sort.by(sortBy).ascending();

        Pageable pageable =
                PageRequest.of(page, size, sort);

        return movieService.getAllMovies(pageable);

    }

    @GetMapping("/search")
public List<Movie> searchMovie(

        @RequestParam String keyword

) {

    return movieService.searchMovie(keyword);

}

@GetMapping("/language")
public List<Movie> getByLanguage(

        @RequestParam String language

) {

    return movieService.getMoviesByLanguage(language);

}
@GetMapping("/filter")
public List<Movie> filter(

        @RequestParam String language,

        @RequestParam String genre

) {

    return movieService
            .getMoviesByLanguageAndGenre(
                    language,
                    genre);

}
}