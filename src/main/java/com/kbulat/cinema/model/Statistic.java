package com.kbulat.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistic {

    @JsonProperty("current_income")
    private final int currentIncome;

    @JsonProperty("number_of_available_seats")
    private final int availableSeatsCount;

    @JsonProperty("number_of_purchased_tickets")
    private final int purchasedTicketCount;

    public Statistic(int currentIncome, int availableSeatsCount, int purchasedTicketCount) {
        this.currentIncome = currentIncome;
        this.availableSeatsCount = availableSeatsCount;
        this.purchasedTicketCount = purchasedTicketCount;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getAvailableSeatsCount() {
        return availableSeatsCount;
    }

    public int getPurchasedTicketCount() {
        return purchasedTicketCount;
    }
}
