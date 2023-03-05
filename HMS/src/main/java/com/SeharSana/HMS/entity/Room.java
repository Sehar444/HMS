package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no")
    private long roomNo;
    @Column(name = "room_location")
    private String roomLocation;
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "room_price")
    private String roomPrice;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
}
