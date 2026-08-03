package com.vkspark.vkspark_backend.service;

import com.vkspark.vkspark_backend.entity.Booking;
import java.util.List;

public interface BookingService {

    Booking saveBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(Long id);

    Booking updateBooking(Long id, Booking booking);

    void deleteBooking(Long id);

    Booking cancelBooking(Long bookingId);
}