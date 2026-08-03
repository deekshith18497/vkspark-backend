package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Coupon;
import com.vkspark.vkspark_backend.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public Coupon saveCoupon(@RequestBody Coupon coupon) {
        return couponService.saveCoupon(coupon);
    }

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable Long id) {
        return couponService.getCouponById(id);
    }

    @PutMapping("/{id}")
    public Coupon updateCoupon(@PathVariable Long id,
                               @RequestBody Coupon coupon) {
        return couponService.updateCoupon(id, coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }

    @GetMapping("/apply")
    public Double applyCoupon(@RequestParam String code,
                              @RequestParam Double amount) {

        return couponService.applyCoupon(code, amount);

    }

}
