package com.kbulat.cinema.service;

import com.kbulat.cinema.model.MovieTheatre;
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

}
