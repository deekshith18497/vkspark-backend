package com.vkspark.vkspark_backend.entity;
import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "seats")
public class Seat extends BaseEntity {

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private String seatType;

    @Column(nullable = false)
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

        @OneToMany(mappedBy = "seat")
    private List<BookingSeat> bookingSeats;
}