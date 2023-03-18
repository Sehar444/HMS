package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ReservationId;
    @Column(name = "arrival_date")
    private java.time.LocalDateTime arrivalDateTime;
    @Column(name = "departure_date")
    private java.time.LocalDateTime departureDateTime;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room_no")
    private Room room;


}
