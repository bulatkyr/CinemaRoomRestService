package com.kbulat.cinema.dto;

import com.kbulat.cinema.model.Seat;

public class PurchaseTicketResponse {

    private final String token;
    private final Seat ticket;

    public PurchaseTicketResponse(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }

    public String getToken() {
        return token;
    }
}
