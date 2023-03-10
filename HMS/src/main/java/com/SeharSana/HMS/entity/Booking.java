package com.SeharSana.HMS.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import  jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "booking_date")
    private int bookingDate;
    @Column(name = "booking_time")
    private int bookingTime;
    @Column(name = "arrival_time")
    private int arrivalTime;
    @Column(name = "departure_time")
    private int departureTime;
    @Column(name = "special_requirements")
    private String specialRequirements;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room_no")
    private Room room;


}
