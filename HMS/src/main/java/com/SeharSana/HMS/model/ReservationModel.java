package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Reservation;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component

public class ReservationModel {
    private int ReservationId;
    private java.time.LocalDateTime arrivalDateTime;
    private java.time.LocalDateTime departureDateTime;
    public Reservation disassemble(){
        Reservation reservation=new Reservation();
        reservation.setReservationId(ReservationId);
        reservation.setArrivalDateTime(arrivalDateTime);
        reservation.setDepartureDateTime(departureDateTime);
        return  reservation;
    }
    public ReservationModel assemble(Reservation reservation){
        ReservationModel reservationmodel=new ReservationModel();
        reservationmodel.setReservationId(reservation.getReservationId());
        reservationmodel.setArrivalDateTime(reservation.getArrivalDateTime());
        reservationmodel.setDepartureDateTime(reservation.getDepartureDateTime());
        return reservationmodel;
    }

}
