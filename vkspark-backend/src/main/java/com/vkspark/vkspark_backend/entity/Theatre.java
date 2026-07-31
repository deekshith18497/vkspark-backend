
package com.vkspark.vkspark_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
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
    private List<Show> shows;
}