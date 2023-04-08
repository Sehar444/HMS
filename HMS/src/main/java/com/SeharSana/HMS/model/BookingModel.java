package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Booking;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Data
public class BookingModel  {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime estimatedCheckInTime;
    private boolean isCancelled;


    public Booking disassemble()
    {
       Booking booking=new Booking();
        booking.setId(this.getBookingId());
        booking.setCheckInDate(this.getCheckInDate());
        booking.setCheckInDate(this.getCheckOutDate());
        return booking;
    }

    public BookingModel assemble(Booking booking)
    {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(booking.getId());
        bookingModel.setCheckInDate(booking.getCheckInDate());
        bookingModel.setCheckOutDate(booking.getCheckOutDate());
        return bookingModel;
    }
    public BookingModel(Booking booking){
        this.bookingId=booking.getId();
        this.checkInDate=booking.getCheckInDate();
        this.checkOutDate=booking.getCheckOutDate();
        this.isCancelled=booking.equals(isCancelled);
    }
    public  BookingModel(){

    }

    public void setGuestModel(GuestModel guestModel) {
    }

    public void setRoomModel(RoomModel roomModel) {
    }

    public void setReserved(boolean b) {
    }
}
