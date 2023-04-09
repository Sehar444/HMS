package com.SeharSana.HMS.entity;

import com.SeharSana.HMS.model.GuestModel;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="guest")
@Data
@Component
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "guest_name")
    private String name;
    @Column(name = "guest_email")
    private String email;
    @Column(name = "guest_phone_number")
    private Long phoneNumber;
    @Column(name = "guest_no_of_persons")
    private Long noOfPersons;
    @OneToMany(mappedBy = "guest")
   private List<Booking> booking;
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservation;

    public GuestModel orElseThrow(String guestNotFound) {
        return new GuestModel();
    }
}