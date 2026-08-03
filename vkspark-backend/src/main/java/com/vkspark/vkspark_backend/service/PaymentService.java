package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    Payment updatePayment(Long id, Payment payment);

    void deletePayment(Long id);

}
