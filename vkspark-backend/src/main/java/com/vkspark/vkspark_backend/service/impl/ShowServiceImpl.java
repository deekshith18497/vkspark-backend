package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Show;
import com.vkspark.vkspark_backend.repository.ShowRepository;
import com.vkspark.vkspark_backend.service.ShowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show saveShow(Show show) {
        return showRepository.save(show);
    }

    @Override
    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
}
