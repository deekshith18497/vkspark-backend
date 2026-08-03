package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Screen;
import com.vkspark.vkspark_backend.service.ScreenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    public Screen saveScreen(@RequestBody Screen screen) {
        return screenService.saveScreen(screen);
    }

    @GetMapping
    public List<Screen> getAllScreens() {
        return screenService.getAllScreens();
    }

    @GetMapping("/{id}")
    public Screen getScreenById(@PathVariable Long id) {
        return screenService.getScreenById(id);
    }

    @PutMapping("/{id}")
    public Screen updateScreen(@PathVariable Long id,
                               @RequestBody Screen screen) {
        return screenService.updateScreen(id, screen);
    }

    @DeleteMapping("/{id}")
    public String deleteScreen(@PathVariable Long id) {
        return screenService.deleteScreen(id);
    }
}