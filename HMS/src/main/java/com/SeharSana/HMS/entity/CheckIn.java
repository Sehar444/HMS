package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="CheckIn_Out")
@Data
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int CheckIn_Out;
    @Column(name = "arrival_date")
    private java.time.LocalDateTime arrivalDateTime;
    @Column(name = "departure_date")
    private java.time.LocalDateTime departureDateTime;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne
    @JoinColumn(name = "room_no")
    private Room room;


}
