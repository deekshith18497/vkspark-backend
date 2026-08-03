package com.vkspark.vkspark_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vkspark.vkspark_backend.entity.Booking;
import com.vkspark.vkspark_backend.entity.Payment;
import com.vkspark.vkspark_backend.enums.PaymentStatus;
import com.vkspark.vkspark_backend.entity.Show;
import com.vkspark.vkspark_backend.entity.Ticket;
import com.vkspark.vkspark_backend.repository.BookingRepository;
import com.vkspark.vkspark_backend.repository.TicketRepository;
import com.vkspark.vkspark_backend.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final BookingRepository bookingRepository;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             BookingRepository bookingRepository) {

        this.ticketRepository = ticketRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Ticket generateTicket(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));

        Payment payment = booking.getPayment();

        if (payment == null || payment.getPaymentStatus() != PaymentStatus.SUCCESS) {
            throw new RuntimeException("Payment not completed");
        }

        Show show = booking.getShow();

        Ticket ticket = new Ticket();

        ticket.setBooking(booking);

        ticket.setTicketNumber("VKS" + System.currentTimeMillis());

        ticket.setMovieName(show.getMovie().getMovieName());

        ticket.setTheatreName(show.getScreen().getTheatre().getTheatreName());

        ticket.setScreenName(show.getScreen().getScreenName());

        ticket.setSeatNumber(booking.getSeat().getSeatNumber());

        ticket.setShowDate(show.getShowDate());

        ticket.setShowTime(show.getShowTime());

        ticket.setQrCode("QR-" + ticket.getTicketNumber());

        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {

        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket Not Found"));
    }

    @Override
    public Ticket getTicketByNumber(String ticketNumber) {

        return ticketRepository.findByTicketNumber(ticketNumber)
                .orElseThrow(() -> new RuntimeException("Ticket Not Found"));
    }

    @Override
    public void deleteTicket(Long id) {

        Ticket ticket = getTicketById(id);

        ticketRepository.delete(ticket);
    }

}