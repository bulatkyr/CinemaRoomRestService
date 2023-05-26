package com.kbulat.cinema.model;

public class Ticket {

    private String token;
    private Seat seat;

    public Ticket() {
    }

    public Ticket(String token, Seat seat) {
        this.token = token;
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
