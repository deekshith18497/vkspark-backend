package com.vkspark.vkspark_backend.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vkspark.vkspark_backend.dto.AuthRequest;
import com.vkspark.vkspark_backend.dto.AuthResponse;
import com.vkspark.vkspark_backend.security.JwtService;

import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication",
     description = "Authentication APIs")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtService jwtService) {

        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
public AuthResponse login(@Valid @RequestBody AuthRequest request) {

    Authentication authentication =
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

    if (authentication.isAuthenticated()) {

        String token = jwtService.generateToken(request.getEmail());

        return new AuthResponse(token);
    }

    throw new RuntimeException("Invalid Credentials");
}
}