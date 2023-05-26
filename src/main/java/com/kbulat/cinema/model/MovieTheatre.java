package com.kbulat.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieTheatre {

    private static final int ROW_COUNT = 9;
    private static final int COLUMN_COUNT = 9;

    @JsonProperty("total_rows")
    private int totalRows;

    @JsonProperty("total_columns")
    private int totalColumns;

    @JsonProperty("available_seats")
    private List<Seat> availableSeats;

    @JsonIgnore
    private List<Seat> unavailableSeats;

    @JsonIgnore
    private List<Ticket> tickets;

    public MovieTheatre() {
        this.totalRows = ROW_COUNT;
        this.totalColumns = COLUMN_COUNT;
        this.availableSeats = new ArrayList<>(81);
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                this.availableSeats.add(new Seat(i + 1, j + 1));
            }
        }
        this.unavailableSeats = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getUnavailableSeats() {
        return unavailableSeats;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}


