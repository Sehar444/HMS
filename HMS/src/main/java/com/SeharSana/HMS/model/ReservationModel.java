package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Payment;
import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component

public class ReservationModel {
    private int ReservationId;
    private LocalDateTime createdTime;
    private Guest guest;
    private Payment payment;
    private Room room;
    public Reservation disassemble(){
        Reservation npReservation=new Reservation();
        npReservation.setId(this.getReservationId());
        npReservation.setCreatedTime(this.getCreatedTime());
        npReservation.setGuest(this.getGuest());
        npReservation.setRoom(this.getRoom());
        npReservation.setPayment(this.getPayment());
        return  npReservation;
    }
    public ReservationModel(Reservation reservation){
        this.ReservationId=reservation.getId();
        this.createdTime=reservation.getCreatedTime();
        this.guest=reservation.getGuest();
        this.room=reservation.getRoom();
        this.payment=reservation.getPayment();

    }

}
