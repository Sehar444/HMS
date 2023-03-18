package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Guest")
@Data
public class Guest {
    public enum Address{
        City
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private long guestId;
    @Column(name = "guest_name")
    private String guestName;
    @Column(name = "guest_cnic")
    private String guestCnic;
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name ="address")
    private String address;
    @Column(name = "no_of_persons")
    private int noOfPersons;
    @OneToMany(mappedBy = "guest")
    private List<Room> guestRoom;
    @OneToMany(mappedBy = "guest")
    private List<Booking> roomBooking;
    @OneToMany(mappedBy = "guest")
    private List<SpecialRequirements> specialRequirementsList;
    @OneToMany(mappedBy = "guest")
    private List<Reservation> checkInList;
    @OneToMany(mappedBy = "guest")
    private List<Payment> paymentList;
}