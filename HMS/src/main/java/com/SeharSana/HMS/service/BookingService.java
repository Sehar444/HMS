package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.BookingRepository;
import com.SeharSana.HMS.model.BookingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public BookingModel confirm(BookingModel bookingModel){
        return bookingModel.assemble(bookingRepository.save(bookingModel.disassemble()));
    }

}
