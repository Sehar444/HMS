package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.Repository.ReservationRepository;
import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.model.ReservationModel;
import com.SeharSana.HMS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;


//    @PostMapping("/CheckInOut")
//    public ReservationModel save(@RequestBody ReservationModel reservationModel) {
//        return reservationService.CheckInout(reservationModel);
//    }
//
//    @GetMapping("/AllCheckInOUt")
//    public List<Reservation> ReservationTotal() {
//        return reservationService.getGuest();
//    }
}
