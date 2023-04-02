package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Hotel")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private int id;
    @Column(name = "hotel_name")
    private String name;
    @Column(name = "hotel_location")
    private String location;
    @Column(name = "hotel_phone_no")
    private Long phoneNo;
    @Column(name = "hotel_email")
    private String email;
    @OneToMany(mappedBy = "hotel")
    List<Room> hotelRoom;
}
