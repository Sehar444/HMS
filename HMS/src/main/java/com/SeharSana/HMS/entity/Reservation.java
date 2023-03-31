package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name="reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(nullable = false)
    private LocalDateTime createdTime;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room_no")
    private Room room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        createdTime = LocalDateTime.now();
        this.payment = payment;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }




}
