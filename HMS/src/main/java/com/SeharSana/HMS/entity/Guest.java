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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "guest_name")
    private String guestName;
    @Column(name = "guest_cnic")
    private Long guestCnic;
    @Column(name = "phone_no")
    private Long phoneNo;
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