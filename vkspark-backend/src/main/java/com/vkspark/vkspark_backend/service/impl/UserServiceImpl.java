package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.User;
import com.vkspark.vkspark_backend.repository.UserRepository;
import com.vkspark.vkspark_backend.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

}