package com.kbulat.cinema.dto;

public class PurchaseTicketErrorResponse {

    private String error;

    public PurchaseTicketErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
