package com.vkspark.vkspark_backend.service.impl;

import com.vkspark.vkspark_backend.entity.Coupon;
import com.vkspark.vkspark_backend.repository.CouponRepository;
import com.vkspark.vkspark_backend.service.CouponService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getCouponById(Long id) {
        return couponRepository.findById(id).orElseThrow();
    }

    @Override
    public Coupon updateCoupon(Long id, Coupon coupon) {

        Coupon existing = getCouponById(id);

        existing.setCode(coupon.getCode());
        existing.setDiscount(coupon.getDiscount());
        existing.setExpiryDate(coupon.getExpiryDate());
        existing.setActive(coupon.getActive());

        return couponRepository.save(existing);
    }

    @Override
    public void deleteCoupon(Long id) {

        Coupon coupon = getCouponById(id);

        couponRepository.delete(coupon);

    }

    @Override
    public Double applyCoupon(String code, Double amount) {

        Coupon coupon = couponRepository.findByCode(code).orElseThrow();

        if (!coupon.getActive()) {
            throw new RuntimeException("Coupon is inactive");
        }

        if (coupon.getExpiryDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Coupon expired");
        }

        return amount - coupon.getDiscount();
    }

}
