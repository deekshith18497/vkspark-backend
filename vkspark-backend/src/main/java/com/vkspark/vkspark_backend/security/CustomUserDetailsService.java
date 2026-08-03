package com.vkspark.vkspark_backend.security;


import com.vkspark.vkspark_backend.entity.User;
import com.vkspark.vkspark_backend.repository.UserRepository;
import com.vkspark.vkspark_backend.security.CustomUserDetails;


import lombok.RequiredArgsConstructor;


import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;



@Service

@RequiredArgsConstructor

public class CustomUserDetailsService 
        implements UserDetailsService {


    private final UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) {


        User user = userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "User not found"
                        )
                );


        return new CustomUserDetails(user);

    }

}