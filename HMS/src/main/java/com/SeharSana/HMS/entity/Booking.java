package com.SeharSana.HMS.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import  jakarta.persistence.*;

@Entity
@Table(name="Booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "guest_id")
    private String guestId;
    @Column(name = "room_no")
    private int roomNo;
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


}
