package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.Repository.BookingRepository;
import com.SeharSana.HMS.entity.Booking;
import com.SeharSana.HMS.model.BookingModel;
import com.SeharSana.HMS.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/booking")
    public BookingModel save(@RequestBody BookingModel bookingModel){
        return bookingService.confirm(bookingModel);
    }
}
