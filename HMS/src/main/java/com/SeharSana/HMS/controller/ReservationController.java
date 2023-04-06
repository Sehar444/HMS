package com.SeharSana.HMS.controller;
import com.SeharSana.HMS.model.ReservationModel;
import com.SeharSana.HMS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private  ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationModel> createReservation(@RequestBody ReservationModel reservationModel) {
        ReservationModel createdReservation = reservationService.createReservation(reservationModel);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationModel> getReservationById(@PathVariable Long id) {
        ReservationModel reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReservationModel>> getAllReservations() {
        List<ReservationModel> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ReservationModel> updateReservation(@RequestBody ReservationModel reservationModel) {
        ReservationModel updatedReservation = reservationService.updateReservation(reservationModel);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

