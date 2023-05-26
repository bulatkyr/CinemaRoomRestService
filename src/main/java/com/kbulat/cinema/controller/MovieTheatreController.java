package com.kbulat.cinema.controller;

import com.kbulat.cinema.dto.PurchaseTicketErrorResponse;
import com.kbulat.cinema.dto.PurchaseTicketRequest;
import com.kbulat.cinema.model.MovieTheatre;
import com.kbulat.cinema.service.MovieTheatreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody PurchaseTicketRequest req) {
        try {
            return ResponseEntity.ok(movieTheatreService.purchaseTicket(req.getRow(), req.getColumn()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new PurchaseTicketErrorResponse(ex.getMessage()));
        }

    }

}
