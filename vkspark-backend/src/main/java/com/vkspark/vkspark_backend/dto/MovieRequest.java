package com.vkspark.vkspark_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class MovieRequest {

    @NotBlank(message = "Movie Name is Required")
    private String movieName;

    @NotBlank(message = "Description is Required")
    private String description;

    @Positive(message = "Duration must be Positive")
    private Integer duration;

    @NotBlank(message = "Language is Required")
    private String language;

    @NotBlank(message = "Genre is Required")
    private String genre;

    @NotBlank(message = "Poster URL is Required")
    private String posterUrl;

    @NotNull(message = "Release Date is Required")
    private LocalDate releaseDate;

    public MovieRequest() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}