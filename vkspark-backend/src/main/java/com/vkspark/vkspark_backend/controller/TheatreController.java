package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Theatre;
import com.vkspark.vkspark_backend.service.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @PostMapping
    public Theatre saveTheatre(@RequestBody Theatre theatre) {
        return theatreService.saveTheatre(theatre);
    }

    @GetMapping
    public List<Theatre> getAllTheatres() {
        return theatreService.getAllTheatres();
    }

    @GetMapping("/{id}")
    public Theatre getTheatreById(@PathVariable Long id) {
        return theatreService.getTheatreById(id);
    }

    @PutMapping("/{id}")
    public Theatre updateTheatre(@PathVariable Long id,
                                 @RequestBody Theatre theatre) {
        return theatreService.updateTheatre(id, theatre);
    }

    @DeleteMapping("/{id}")
    public String deleteTheatre(@PathVariable Long id) {

        theatreService.deleteTheatre(id);

        return "Theatre Deleted Successfully";
    }
}