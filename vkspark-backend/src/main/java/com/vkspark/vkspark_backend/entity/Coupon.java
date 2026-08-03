package com.vkspark.vkspark_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "coupons")
public class Coupon extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    private Boolean active;
}