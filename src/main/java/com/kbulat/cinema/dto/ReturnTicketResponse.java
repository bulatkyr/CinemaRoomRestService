package com.kbulat.cinema.dto;

import com.kbulat.cinema.model.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReturnTicketResponse {

    @JsonProperty("returned_ticket")
    private final Seat returnedSeat;


    public ReturnTicketResponse(Seat returnedSeat) {
        this.returnedSeat = returnedSeat;
    }

    public Seat getReturnedSeat() {
        return returnedSeat;
    }

}
