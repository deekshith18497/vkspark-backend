package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Coupon;

import java.util.List;

public interface CouponService {

    Coupon saveCoupon(Coupon coupon);

    List<Coupon> getAllCoupons();

    Coupon getCouponById(Long id);

    Coupon updateCoupon(Long id, Coupon coupon);

    void deleteCoupon(Long id);

    Double applyCoupon(String code, Double amount);

}
