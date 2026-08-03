package com.vkspark.vkspark_backend.service.impl;
import com.vkspark.vkspark_backend.enums.BookingStatus;
import com.vkspark.vkspark_backend.enums.PaymentStatus;
import com.vkspark.vkspark_backend.entity.Booking;
import com.vkspark.vkspark_backend.repository.BookingRepository;
import com.vkspark.vkspark_backend.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
      
    booking.setBookingStatus(BookingStatus.PENDING);

    return bookingRepository.save(booking);
}
    

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {

        Booking existing = getBookingById(id);

        existing.setCustomerName(booking.getCustomerName());
        existing.setCustomerPhone(booking.getCustomerPhone());
        existing.setTotalAmount(booking.getTotalAmount());
        existing.setSeat(booking.getSeat());
        existing.setShow(booking.getShow());

        return bookingRepository.save(existing);
    }

    @Override
    public void deleteBooking(Long id) {

        Booking booking = getBookingById(id);

        bookingRepository.delete(booking);
    }

    @Override
public Booking cancelBooking(Long bookingId) {

    Booking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking Not Found"));

    if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
        throw new RuntimeException("Booking Already Cancelled");
    }

    booking.setBookingStatus(BookingStatus.CANCELLED);

    booking.getSeat().setBooked(false);

    booking.getPayment().setPaymentStatus(PaymentStatus.REFUNDED);

    return bookingRepository.save(booking);
}
}