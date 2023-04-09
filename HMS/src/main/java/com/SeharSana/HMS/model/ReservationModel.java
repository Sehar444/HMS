package com.SeharSana.HMS.model;
import com.SeharSana.HMS.Utility.ReservationStatus;
import com.SeharSana.HMS.entity.Reservation;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component

public class ReservationModel {
    private Long ReservationId;
    private boolean checkIn;
    private boolean checkOut;
    private RoomModel roomModel;
    private GuestModel guestModel;

    public ReservationModel() {
    }

    public Reservation disassemble() {
        Reservation reservation = new Reservation( );
        reservation.setId(ReservationId);
        reservation.setStatus(ReservationStatus.CHECKED_IN);
        reservation.setStatus(ReservationStatus.CHECKED_OUT);
        reservation.setStatus(ReservationStatus.CANCELLED);
        reservation.setRoom(roomModel.disassemble( ));
        reservation.setGuest(guestModel.disassemble( ));


        return reservation;
    }

    public ReservationModel assemble(Reservation reservation) {
        ReservationModel reservationModel = new ReservationModel( );
        reservationModel.setReservationId(reservation.getId( ));
        reservationModel.setCheckIn(reservationModel.isCheckIn( ));
        reservationModel.setCheckOut(reservationModel.isCheckOut( ));
        reservationModel.setRoomModel(new RoomModel(reservation.getRoom( )).assemble(reservation.getRoom( )));
        reservationModel.setGuestModel(new GuestModel( ).assemble(reservation.getGuest( )));
        return reservationModel;
    }


    public ReservationModel(Reservation reservation) {
        this.ReservationId = reservation.getId( );
        this.checkIn = reservation.isCheckIn( );
        this.checkOut = (boolean) reservation.isCheckOut( );
        this.roomModel = new RoomModel(reservation.getRoom() );
        this.guestModel = new GuestModel(reservation.getGuest( ));
    }
}




