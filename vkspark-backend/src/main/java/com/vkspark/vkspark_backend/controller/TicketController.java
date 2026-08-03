package com.vkspark.vkspark_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vkspark.vkspark_backend.entity.Ticket;
import com.vkspark.vkspark_backend.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Generate Ticket
    @PostMapping("/generate/{bookingId}")
    public Ticket generateTicket(@PathVariable Long bookingId) {
        return ticketService.generateTicket(bookingId);
    }

    // Get All Tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Get Ticket By Id
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    // Get Ticket By Ticket Number
    @GetMapping("/number/{ticketNumber}")
    public Ticket getTicketByNumber(@PathVariable String ticketNumber) {
        return ticketService.getTicketByNumber(ticketNumber);
    }

    // Delete Ticket
    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return "Ticket Deleted Successfully";
    }

}