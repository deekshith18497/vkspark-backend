package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Show;
import com.vkspark.vkspark_backend.service.ShowService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@Tag(
        name = "Theatres",
        description = "Theatre APIs"
)
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public Show saveShow(@RequestBody Show show) {
        return showService.saveShow(show);
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }
}