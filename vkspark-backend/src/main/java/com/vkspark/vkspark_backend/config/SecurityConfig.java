package com.vkspark.vkspark_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.vkspark.vkspark_backend.security.CustomUserDetailsService;
import com.vkspark.vkspark_backend.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(
            CustomUserDetailsService customUserDetailsService,
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.customUserDetailsService = customUserDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(customUserDetailsService);

        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration)
            throws Exception {

        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS))

                .authenticationProvider(authenticationProvider())

                .addFilterBefore(
                        jwtAuthenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests(auth -> auth

                        // Authentication APIs
                        .requestMatchers(
        "/auth/**",
        "/swagger-ui/**",
        "/swagger-ui.html",
        "/v3/api-docs/**",
        "/v3/api-docs",
        "/webjars/**"
).permitAll()

                        // Movies
                        .requestMatchers(HttpMethod.GET, "/movies/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/movies/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/movies/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/movies/**").hasRole("ADMIN")

                        // Theatre
                        .requestMatchers(HttpMethod.GET, "/theatres/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/theatres/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/theatres/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/theatres/**").hasRole("ADMIN")

                        // Screens
                        .requestMatchers(HttpMethod.GET, "/screens/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/screens/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/screens/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/screens/**").hasRole("ADMIN")

                        // Shows
                        .requestMatchers(HttpMethod.GET, "/shows/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/shows/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/shows/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/shows/**").hasRole("ADMIN")

                        // Booking
                        .requestMatchers("/bookings/**").hasRole("USER")

                        // Payment
                        .requestMatchers("/payments/**").hasRole("USER")

                        // Ticket
                        .requestMatchers("/tickets/**").hasRole("USER")

                        // Admin Dashboard
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .anyRequest().authenticated());

        return http.build();
    }
}