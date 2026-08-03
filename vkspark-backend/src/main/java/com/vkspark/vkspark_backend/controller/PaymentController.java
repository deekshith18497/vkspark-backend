package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Payment;
import com.vkspark.vkspark_backend.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@Tag(
        name = "Payments",
        description = "Payment APIs"
)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @Operation(
        summary = "Make Payment",
        description = "Creates payment"
)
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id,
                                 @RequestBody Payment payment) {

        return paymentService.updatePayment(id,payment);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id){

        paymentService.deletePayment(id);

        return "Payment Deleted Successfully";
    }

}