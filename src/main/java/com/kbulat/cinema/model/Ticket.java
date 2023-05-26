package com.kbulat.cinema.model;

public class Ticket {

    private final String token;
    private final Seat seat;

    public Ticket(String token, Seat seat) {
        this.token = token;
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }

    public Seat getSeat() {
        return seat;
    }
}
