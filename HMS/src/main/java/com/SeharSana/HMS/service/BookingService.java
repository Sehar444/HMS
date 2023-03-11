package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.BookingRepository;
import com.SeharSana.HMS.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    public Booking confirm(Booking booking){
        return bookingRepository.save(booking);
    }
}
