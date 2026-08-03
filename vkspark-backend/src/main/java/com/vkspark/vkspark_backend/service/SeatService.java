package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Seat;

import java.util.List;

public interface SeatService {

    Seat saveSeat(Seat seat);

    List<Seat> getAllSeats();

}
