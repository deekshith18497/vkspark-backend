package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Seat;
import com.vkspark.vkspark_backend.repository.SeatRepository;
import com.vkspark.vkspark_backend.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }
}