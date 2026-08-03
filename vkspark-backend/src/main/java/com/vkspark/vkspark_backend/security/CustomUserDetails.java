package com.vkspark.vkspark_backend.security;


import com.vkspark.vkspark_backend.entity.User;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Collection;


@RequiredArgsConstructor

public class CustomUserDetails 
        implements UserDetails {


    private final User user;



    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {


        return List.of(
                new SimpleGrantedAuthority(
                        "ROLE_" + user.getRole()
                )
        );

    }



    @Override
    public String getPassword() {

        return user.getPassword();

    }



    @Override
    public String getUsername() {

        return user.getEmail();

    }



    @Override
    public boolean isAccountNonExpired() {

        return true;

    }



    @Override
    public boolean isAccountNonLocked() {

        return true;

    }



    @Override
    public boolean isCredentialsNonExpired() {

        return true;

    }



    @Override
    public boolean isEnabled() {

        return true;

    }

}