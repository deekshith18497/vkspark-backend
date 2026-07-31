package com.vkspark.vkspark_backend.entity;
import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends BaseEntity {

    @Column(nullable = false)
    private String movieName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String genre;

    private String posterUrl;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows;

    @OneToMany(mappedBy = "movie")
    private List<Review> review;

}