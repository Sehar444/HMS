package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Hotel")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="hotel-id")
    private int hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "hotel_location")
    private String hotelLocation;
}
