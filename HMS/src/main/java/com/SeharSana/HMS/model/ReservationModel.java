package com.SeharSana.HMS.model;

import com.SeharSana.HMS.Utility.ReservationStatus;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Payment;
import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.entity.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Data
@Component

public class ReservationModel {
    private Long ReservationId;
    private Long guestId;
    private Long roomId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
    private boolean checkIn;
    private boolean checkOut;
    private PaymentModel payment;

    public ReservationModel() {}

    public ReservationModel(Reservation reservation) {
            this.ReservationId = reservation.getId();
            this.guestId = reservation.getGuest().getId();
            this.roomId = reservation.getId();
            this.checkInDate = reservation.getCheckInDate();
            this.checkOutDate = reservation.getCheckOutDate();
            this.checkIn = reservation.isCheckIn();
            this.checkOut = reservation.isCheckOut();
            if (reservation.getPayment() != null) {
                this.payment = new PaymentModel(reservation.getPayment());
            }
        }

        public Reservation disassemble() {
            Reservation reservation = new Reservation();
            reservation.setId(this.ReservationId);
            reservation.setCheckIn(this.checkIn);
            reservation.setCheckOut(this.checkOut);
            reservation.setCheckInDate(this.checkInDate);
            reservation.setCheckOutDate(this.checkOutDate);
            return reservation;
        }
    }




