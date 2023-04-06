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
@Component
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private List<Room> room;
    @OneToMany(mappedBy = "guest")
   private List<Booking> booking;

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    @OneToMany(mappedBy = "guest")
    private List<SpecialRequirements> specialRequirements;
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservation;
    @OneToMany(mappedBy = "guest")
    private List<Payment> payment;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNoOfPersons() {
        return noOfPersons;
    }

    public void setNoOfPersons(Long noOfPersons) {
        this.noOfPersons = noOfPersons;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }


    public List<SpecialRequirements> getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirement(List<SpecialRequirements> specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }


    public GuestModel orElseThrow(String guestNotFound) {
        GuestModel guestModel = null;
        return guestModel;
    }

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    public Set<Reservation> getReservations() {
        if (reservations == null) {
            reservations = new HashSet<>();
        }
        return reservations;
    }
}