package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="SpecialRequirements")
@Data
public class SpecialRequirements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int requirementId;
    @Column(name = "car_parking")
    private String carParking;
    @Column(name = "room_phone_service")
    private String phoneService;
    @Column(name = "room_service")
    private String roomService;
    @Column(name = "laundry")
    private String laundry;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
}
