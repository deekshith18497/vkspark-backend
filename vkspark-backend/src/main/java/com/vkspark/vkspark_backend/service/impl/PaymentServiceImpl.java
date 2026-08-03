package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Payment;
import com.vkspark.vkspark_backend.enums.PaymentStatus;
import com.vkspark.vkspark_backend.repository.PaymentRepository;
import com.vkspark.vkspark_backend.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment savePayment(Payment payment) {

        payment.setPaymentStatus(PaymentStatus.PENDING);

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {

        Payment existing = getPaymentById(id);

        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setAmount(payment.getAmount());
        existing.setPaymentStatus(payment.getPaymentStatus());
        existing.setBooking(payment.getBooking());

        return paymentRepository.save(existing);
    }

    @Override
    public void deletePayment(Long id) {

        Payment payment = getPaymentById(id);

        paymentRepository.delete(payment);

    }
}