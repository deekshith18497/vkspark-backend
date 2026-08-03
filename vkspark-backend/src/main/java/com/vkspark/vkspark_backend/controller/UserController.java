package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.User;
import com.vkspark.vkspark_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(user);

    }

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();

    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUser(id);

    }

}
