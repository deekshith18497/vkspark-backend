package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Screen;
import com.vkspark.vkspark_backend.repository.ScreenRepository;
import com.vkspark.vkspark_backend.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Override
    public Screen saveScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    @Override
    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    @Override
    public Screen getScreenById(Long id) {
        return screenRepository.findById(id).orElse(null);
    }

    @Override
    public Screen updateScreen(Long id, Screen screen) {

        Screen existingScreen = getScreenById(id);

        if (existingScreen == null) {
            return null;
        }

        existingScreen.setScreenName(screen.getScreenName());
        existingScreen.setTotalSeats(screen.getTotalSeats());
        existingScreen.setTheatre(screen.getTheatre());

        return screenRepository.save(existingScreen);
    }

    @Override
    public String deleteScreen(Long id) {

        Screen screen = getScreenById(id);

        if (screen == null) {
            return "Screen Not Found";
        }

        screenRepository.delete(screen);

        return "Screen Deleted Successfully";
    }
}