package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Screen;

import java.util.List;

public interface ScreenService {

    Screen saveScreen(Screen screen);

    List<Screen> getAllScreens();

    Screen getScreenById(Long id);

    Screen updateScreen(Long id, Screen screen);

    String deleteScreen(Long id);
}