package com.SeharSana.HMS.entity;

import com.SeharSana.HMS.Utility.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="reservation")
@Component
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;

    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room_no")
    private Room room;
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    // constructors, getters, and setters

    public void setGuest(Guest guest) {
        this.guest = guest;
        guest.getReservations( ).add(this);
    }

    public void setRoom(Room room) {
        this.room = room;
        room.getReservations( ).add(this);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        payment.setReservation(this);


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public Guest getGuest() {
        return guest;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Object getRoom() {
        return room;
    }

    public boolean isCheckIn() {
        return isCheckIn();
    }

    public boolean isCheckOut() {
        return isCheckOut();
    }

    public void setCheckIn(boolean checkIn) {
    }

    public void setCheckOut(boolean checkOut) {
    }
}