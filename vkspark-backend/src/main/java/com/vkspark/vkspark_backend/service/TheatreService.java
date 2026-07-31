package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Theatre;

import java.util.List;

public interface TheatreService {

    Theatre saveTheatre(Theatre theatre);

    List<Theatre> getAllTheatres();

    Theatre getTheatreById(Long id);

    Theatre updateTheatre(Long id, Theatre theatre);

    void deleteTheatre(Long id);

}