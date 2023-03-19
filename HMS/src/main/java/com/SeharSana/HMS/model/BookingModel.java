package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Booking;
import com.SeharSana.HMS.entity.Guest;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookingModel {
    private Long bookingId;

    public Booking disassemble() {
        Booking booking = new Booking();
        booking.setBookingId(bookingId);
        return booking;
    }
    public BookingModel assemble(Booking booking) {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(booking.getBookingId());
        return bookingModel;
    }
}