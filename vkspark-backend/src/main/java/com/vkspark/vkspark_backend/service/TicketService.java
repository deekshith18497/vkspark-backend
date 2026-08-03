package com.vkspark.vkspark_backend.service;

import java.util.List;

import com.vkspark.vkspark_backend.entity.Ticket;

public interface TicketService {

    Ticket generateTicket(Long bookingId);

    List<Ticket> getAllTickets();

    Ticket getTicketById(Long id);

    Ticket getTicketByNumber(String ticketNumber);

    void deleteTicket(Long id);

}