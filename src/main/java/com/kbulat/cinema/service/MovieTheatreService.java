package com.kbulat.cinema.service;

import com.kbulat.cinema.model.MovieTheatre;
import com.kbulat.cinema.model.Seat;
import com.kbulat.cinema.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieTheatreService {

    private final MovieTheatre movieTheatre;

    public MovieTheatreService() {
        this.movieTheatre = new MovieTheatre();
    }

    public MovieTheatre getMovieTheatre() {
        return movieTheatre;
    }

    public Ticket purchaseTicket(int row, int column) throws Exception {
        if (row > 9 || row < 1 || column < 1 || column > 9) {
            throw new Exception("The number of a row or a column is out of bounds!");
        }
        for (Seat seat : movieTheatre.getAvailableSeats()) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                movieTheatre.getAvailableSeats().remove(seat);
                movieTheatre.getUnavailableSeats().add(seat);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), seat);
                movieTheatre.getTickets().add(ticket);
                return ticket;
            }
        }
        throw new Exception("The ticket has been already purchased!");
    }

    public Ticket returnTicket(String token) throws Exception {
        if (token == null || token.isBlank()) {
            throw new Exception("Wrong token!");
        }
        Ticket ticket = movieTheatre.getTickets().stream()
                .filter(t -> t.getToken().equals(token))
                .findFirst()
                .orElseThrow(() -> new Exception("Wrong token!"));

        movieTheatre.getUnavailableSeats().remove(ticket.getSeat());
        movieTheatre.getAvailableSeats().add(ticket.getSeat());
        movieTheatre.getTickets().remove(ticket);
        return ticket;
    }

}
