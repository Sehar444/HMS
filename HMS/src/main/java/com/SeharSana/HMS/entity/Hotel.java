package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Hotel")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="hotel_id")
    private int hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    @Column(name = "hotel_location")
    private String hotelLocation;
    @Column(name = "hotel_phone_no")
    private Long phoneNo;
    @Column(name = "email")
    private String email;
    @Column(name = "contact_person")
    private Long phone_no;
    @OneToMany(mappedBy = "hotel")
    List<Room> hotelRoom;
}
