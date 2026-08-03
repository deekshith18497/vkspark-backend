package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Seat;
import com.vkspark.vkspark_backend.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public Seat saveSeat(@RequestBody Seat seat) {
        return seatService.saveSeat(seat);
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }
}