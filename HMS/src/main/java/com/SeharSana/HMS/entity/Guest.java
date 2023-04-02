package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.List;

@Entity
@Table(name="guest")
@Component
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guest_id")
    private Long id;
    @Column(name = "guest_name")
    private String name;
    @Column(name = "guest_cnic")
    private Long cnic;
    @Column(name = "guest_phone_no")
    private Long phoneNo;
    @Column(name = "guest_address")
    private String address;
    @Column(name = "guest_no_of_persons")
    private Long noOfPersons;
    @OneToMany(mappedBy = "guest")
    private List<Room> room;
//    @OneToMany(mappedBy = "guest")
//    private List<Booking> booking;
    @OneToMany(mappedBy = "guest")
    private List<SpecialRequirements> specialRequirements;
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservation;
    @OneToMany(mappedBy = "guest")
    private List<Payment> payment;

    public Long getId() {
        return id;
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

    public Long getCnic() {
        return cnic;
    }

    public void setCnic(Long cnic) {
        this.cnic = cnic;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}