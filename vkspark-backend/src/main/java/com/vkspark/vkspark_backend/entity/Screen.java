package com.vkspark.vkspark_backend.entity;
import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "screens")
public class Screen extends BaseEntity {

    @Column(nullable = false)
    private String screenName;

    @Column(nullable = false)
    private Integer totalSeats;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    
    @OneToMany(mappedBy = "screen")
    private List<Show> shows;
    
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}