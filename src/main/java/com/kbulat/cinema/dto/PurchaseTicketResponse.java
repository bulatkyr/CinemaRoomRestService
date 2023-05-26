package com.kbulat.cinema.dto;

import com.kbulat.cinema.model.Seat;

public class PurchaseTicketResponse {

    private String token;
    private Seat ticket;

    public PurchaseTicketResponse() {
    }

    public PurchaseTicketResponse(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
