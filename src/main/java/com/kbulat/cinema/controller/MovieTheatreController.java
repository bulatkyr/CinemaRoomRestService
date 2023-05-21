package com.kbulat.cinema.controller;

import com.kbulat.cinema.model.MovieTheatre;
import com.kbulat.cinema.service.MovieTheatreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieTheatreController {

    private final MovieTheatreService movieTheatreService;

    public MovieTheatreController(MovieTheatreService movieTheatreService) {
        this.movieTheatreService = movieTheatreService;
    }

    @GetMapping("/seats")
    public MovieTheatre getMovieTheatre() {
        return movieTheatreService.getMovieTheatre();
    }

}
