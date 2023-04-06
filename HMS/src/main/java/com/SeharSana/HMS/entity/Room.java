package com.SeharSana.HMS.entity;

import com.SeharSana.HMS.model.RoomModel;
import com.SeharSana.HMS.Utility.EnRoomType;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="room")
@Component
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "room_no", unique = true)
    private Long  roomNumber;
    @Column(name = "beds")
    private int beds;
    @Column(name="room_price")
    private long roomPrice;
    public boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private EnRoomType roomType;
    @Column(name ="rooms_type")
    private String roomTypes;

    public Room(){
        this.isReserved();
    }

    public EnRoomType getRoomType()
    {
        return roomType;
    }

    public void setRoomType(EnRoomType roomType) {
        this.roomType = roomType;
    }

    public String getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(String roomTypes) {
        this.roomTypes = roomTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(long roomPrice) {
        this.roomPrice = roomPrice;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        if (reservation != null) {
            this.reservation = reservation;
            reservation.setRoom(this);
        }
    }

    public boolean isReserved() {
        return reservation != null;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setRoomType(String toString) {
    }

    public RoomModel orElseThrow(Object roomNotFound) {
        return null;
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
