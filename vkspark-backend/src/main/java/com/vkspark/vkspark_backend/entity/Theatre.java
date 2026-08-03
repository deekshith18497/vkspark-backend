package com.vkspark.vkspark_backend.entity;
import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "theatres")
public class Theatre extends BaseEntity {

    @Column(nullable = false)
    private String theatreName;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer totalScreens;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
}