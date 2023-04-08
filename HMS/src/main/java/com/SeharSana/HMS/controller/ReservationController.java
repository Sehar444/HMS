package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@Lazy
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/list")
    public ResponseEntity<List<Reservation>> getAllReservations()
    {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id)
    {
        Reservation reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation)
    {
        return reservationService.createReservation(reservation);

    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable Long id
            , @RequestBody Reservation reservationUpdates)
    {
        return reservationService.updateReservation(id, reservationUpdates);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);

    }
}
