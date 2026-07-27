package com.vkspark.vkspark_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/movies")
    public String getMovies() {
        return "Welcome to VKSpark Movie API";
    }

}