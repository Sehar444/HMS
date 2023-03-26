package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="Room")
@Data
public class Room {
    public enum RoomType{
        Classic_room,
        Luxury_room,


    }
    public enum RoomLocation{
        Corridor_Room,
        Balcony_Room
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_no")
    private long roomNo;
    private RoomLocation roomLocation;
    private RoomType roomType;
    @Column(name = "room_price")
    private long roomPrice;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
