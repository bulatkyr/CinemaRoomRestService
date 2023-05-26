package com.kbulat.cinema.service;

import com.kbulat.cinema.model.MovieTheatre;
import com.kbulat.cinema.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class MovieTheatreService {

    private final MovieTheatre movieTheatre;

    public MovieTheatreService() {
        this.movieTheatre = new MovieTheatre();
    }

    public MovieTheatre getMovieTheatre() {
        return movieTheatre;
    }

    public Seat purchaseTicket(int row, int column) throws Exception {
        if (row > 9 || row < 1 || column < 1 || column > 9) {
            throw new Exception("The number of a row or a column is out of bounds!");
        }
        for (Seat seat : movieTheatre.getAvailableSeats()) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                movieTheatre.getAvailableSeats().remove(seat);
                movieTheatre.getUnavailableSeats().add(seat);
                return seat;
            }
        }
        throw new Exception("The ticket has been already purchased!");
    }

}
