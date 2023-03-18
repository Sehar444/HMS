package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.model.ReservationModel;
import com.SeharSana.HMS.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @PostMapping("/CheckInOut")
    public ReservationModel save(@RequestBody ReservationModel reservationModel){
        return reservationService.CheckInout(reservationModel);
    }
}
