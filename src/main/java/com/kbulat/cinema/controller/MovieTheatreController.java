package com.kbulat.cinema.controller;

import com.kbulat.cinema.dto.*;
import com.kbulat.cinema.model.MovieTheatre;
import com.kbulat.cinema.model.Ticket;
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
            Ticket ticket = movieTheatreService.purchaseTicket(req.getRow(), req.getColumn());
            return ResponseEntity.ok(new PurchaseTicketResponse(ticket.getToken(), ticket.getSeat()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
        }

    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody ReturnTicketRequest request) {
        try {
            Ticket returnTicket = movieTheatreService.returnTicket(request.getToken());
            return ResponseEntity.ok(new ReturnTicketResponse(returnTicket.getSeat()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new ErrorResponse(ex.getMessage()));
        }
    }

}
