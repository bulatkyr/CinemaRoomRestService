package com.kbulat.cinema.service;

import com.kbulat.cinema.dto.PurchaseTicketResponse;
import com.kbulat.cinema.model.MovieTheatre;
import com.kbulat.cinema.model.Seat;
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

    public PurchaseTicketResponse purchaseTicket(int row, int column) throws Exception {
        if (row > 9 || row < 1 || column < 1 || column > 9) {
            throw new Exception("The number of a row or a column is out of bounds!");
        }
        for (Seat seat : movieTheatre.getAvailableSeats()) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                movieTheatre.getAvailableSeats().remove(seat);
                movieTheatre.getUnavailableSeats().add(seat);
                String token = UUID.randomUUID().toString();
                movieTheatre.getTokenSeatMap().put(token, seat);
                return new PurchaseTicketResponse(token, seat);
            }
        }
        throw new Exception("The ticket has been already purchased!");
    }

    public Seat returnSeat(String token) throws Exception {
        if (token == null || token.isBlank()) {
            throw new Exception("Wrong token!");
        }
        Seat seat = movieTheatre.getTokenSeatMap().get(token);
        if (seat == null) {
            throw new Exception("Wrong token!");
        }
        movieTheatre.getUnavailableSeats().remove(seat);
        movieTheatre.getAvailableSeats().add(seat);
        movieTheatre.getTokenSeatMap().remove(token);
        return seat;
    }

}
