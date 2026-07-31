package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Theatre;
import com.vkspark.vkspark_backend.repository.TheatreRepository;
import com.vkspark.vkspark_backend.service.TheatreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Theatre saveTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    @Override
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    @Override
    public Theatre getTheatreById(Long id) {

        return theatreRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Theatre not found with id : " + id));
    }

    @Override
    public Theatre updateTheatre(Long id, Theatre updatedTheatre) {

        Theatre theatre = getTheatreById(id);

        theatre.setTheatreName(updatedTheatre.getTheatreName());
        theatre.setCity(updatedTheatre.getCity());
        theatre.setAddress(updatedTheatre.getAddress());
        theatre.setTotalScreens(updatedTheatre.getTotalScreens());

        return theatreRepository.save(theatre);
    }

    @Override
    public void deleteTheatre(Long id) {

        Theatre theatre = getTheatreById(id);

        theatreRepository.delete(theatre);
    }
}