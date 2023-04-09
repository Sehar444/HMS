package com.SeharSana.HMS.entity;

import com.SeharSana.HMS.Utility.ReservationStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name="reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "status")
    private ReservationStatus status;

    public boolean isCheckIn()
    {
        return isCheckIn();
    }

    public Object isCheckOut()
    {
        return isCheckOut();
    }

    public void setCheckIn(boolean checkIn)
    {
    }

    public void setCheckOut(Object checkOut) {
    }

    // constructors, getters, and setters


}