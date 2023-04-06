package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Booking;
import com.SeharSana.HMS.entity.Guest;
import lombok.Data;
import org.springframework.format.datetime.standard.DateTimeContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
@Data
public class BookingModel extends  Booking {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime estimatedCheckInTime;
    private boolean isCancelled;
    private GuestModel guestModel;
    private RoomModel roomModel;


    public Booking disassemble() {
        Booking booking = new Booking();
        booking.getId();
        booking.getCheckInDate();
        booking.getCheckOutDate();
        booking.getEstimatedCheckInTime();
        booking.setRoom(this.getRoomModel().disassemble());
        booking.setGuest(this.getGuestModel().disassemble());
        return booking;
    }

    public BookingModel assemble(Booking booking) {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(booking.getId());
        bookingModel.setCheckInDate(booking.getCheckInDate());
        bookingModel.setCheckOutDate(booking.getCheckOutDate());
        bookingModel.setEstimatedCheckInTime(booking.getEstimatedCheckInTime());
        return bookingModel;
    }
    public BookingModel(Booking booking){
        this.bookingId=booking.getId();
        this.checkInDate=booking.getCheckInDate();
        this.checkOutDate=booking.getCheckOutDate();
        this.estimatedCheckInTime=booking.getEstimatedCheckInTime();
        this.isCancelled=booking.equals(isCancelled);
        this.guestModel=booking.getGuest().orElseThrow("Guest Not Found");
        this.roomModel=booking.getRoom().orElseThrow("Room Not Found");
    }
    public  BookingModel(){

    }

}
