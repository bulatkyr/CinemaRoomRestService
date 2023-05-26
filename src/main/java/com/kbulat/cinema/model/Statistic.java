package com.kbulat.cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistic {

    @JsonProperty("current_income")
    private int currentIncome;

    @JsonProperty("number_of_available_seats")
    private int availableSeatsCount;

    @JsonProperty("number_of_purchased_tickets")
    private int purchasedTicketCount;

    public Statistic() {
    }


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
