package com.vkspark.vkspark_backend.repository;

import com.vkspark.vkspark_backend.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}