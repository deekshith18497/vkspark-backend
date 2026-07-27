package com.vkspark.vkspark_backend.entity;
import java.util.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String pinCode;

     @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
//l
}