package com.vkspark.vkspark_backend.controller;

import com.vkspark.vkspark_backend.entity.Booking;
import com.vkspark.vkspark_backend.service.BookingService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@Tag(
        name="Bookings",
        description="Booking APIs"
)
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @Tag(
        name = "Bookings",
        description = "Booking APIs"
)
    public Booking saveBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable Long id,
                                 @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    @PutMapping("/cancel/{bookingId}")
    @Tag(
        name = "Cancellation",
        description = "Cancellation APIs"
)
    public Booking cancelBooking(@PathVariable Long bookingId) {

    return bookingService.cancelBooking(bookingId);

}
}