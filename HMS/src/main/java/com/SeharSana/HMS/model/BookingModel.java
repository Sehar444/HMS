package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Booking;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
public class BookingModel  {
    private Long bookingId;
    private String checkInDate;
    private String checkOutDate;
    private boolean isCancelled;

    private RoomModel roomModel;
    private GuestModel guestModel;


    public Booking disassemble()
    {
       Booking booking=new Booking();
        booking.setId(this.getBookingId());
        booking.setCheckInDate(this.getCheckInDate());
        booking.setCheckInDate(this.getCheckOutDate());
        booking.setRoom(roomModel.disassemble());
        booking.setGuest(guestModel.disassemble());

        return booking;
    }

    public BookingModel assemble(Booking booking)
    {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(booking.getId());
        bookingModel.setCheckInDate(booking.getCheckInDate());
        bookingModel.setCheckOutDate(booking.getCheckOutDate());
        bookingModel.setRoomModel(new RoomModel(booking.getRoom( )).assemble(booking.getRoom()));
        bookingModel.setGuestModel(new GuestModel(  ));


        return bookingModel;
    }
    public BookingModel(Booking booking){
        this.bookingId=booking.getId();
        this.checkInDate=booking.getCheckInDate();
        this.checkOutDate=booking.getCheckOutDate();
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
