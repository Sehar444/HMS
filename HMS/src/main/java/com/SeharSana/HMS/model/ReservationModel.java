package com.SeharSana.HMS.model;
import com.SeharSana.HMS.Utility.ReservationStatus;
import com.SeharSana.HMS.entity.Reservation;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component

public class ReservationModel {
    private Long ReservationId;
    private Long guestId;
    private Long roomId;
    private boolean checkIn;
    private boolean checkOut;
    private PaymentModel payment;

    public ReservationModel()
    {
    }

    public Reservation disassemble()
    {
        Reservation reservation = new Reservation( );
        reservation.setId(ReservationId);
        reservation.setStatus(ReservationStatus.CHECKED_IN);
        reservation.setStatus(ReservationStatus.CHECKED_OUT);
        reservation.setStatus(ReservationStatus.CANCELLED);
        return reservation;
    }

    public ReservationModel assemble(Reservation reservation)
    {
        ReservationModel reservationModel = new ReservationModel( );
        reservationModel.setReservationId(reservation.getId( ));
        reservationModel.setCheckIn(reservationModel.isCheckIn( ));
        reservationModel.setCheckOut(reservationModel.isCheckOut( ));
        return reservationModel;
    }
}




