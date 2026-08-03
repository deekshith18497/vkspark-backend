package com.vkspark.vkspark_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vkspark.vkspark_backend.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.paymentStatus = 'SUCCESS'")
Double getTotalRevenue();

}