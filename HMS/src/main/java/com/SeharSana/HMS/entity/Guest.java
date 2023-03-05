package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Guest")
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guest_id")
    private long guestId;
    @Column(name = "guest_name")
    private String guestName;
    @Column(name = "guest_cnic")
    private long guestCnic;
    @Column(name = "phone_no")
    private long phoneNo;
    @Column(name ="address")
    private String address;
    @Column(name = "no_of_persons")
    private int noOfPersons;

}