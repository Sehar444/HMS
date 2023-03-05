package com.SeharSana.HMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="Inventory")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_status")
    private boolean roomStatus;


}
