package com.vkspark.vkspark_backend.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String ticketNumber;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(nullable = false)
    private String movieName;

    @Column(nullable = false)
    private String theatreName;

    @Column(nullable = false)
    private String screenName;

    @Column(nullable = false)
    private String seatNumber;

    @Column(nullable = false)
    private LocalDate showDate;

    @Column(nullable = false)
    private LocalTime showTime;

    private String qrCode;
}