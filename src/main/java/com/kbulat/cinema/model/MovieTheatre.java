package com.kbulat.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MovieTheatre {

    private static final int ROW_COUNT = 9;
    private static final int COLUMN_COUNT = 9;

    @JsonProperty("total_rows")
    private final int totalRows;

    @JsonProperty("total_columns")
    private final int totalColumns;

    @JsonProperty("available_seats")
    private final List<Seat> availableSeats;

    @JsonIgnore
    private final List<Seat> unavailableSeats;

    @JsonIgnore
    private final List<Ticket> tickets;

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


