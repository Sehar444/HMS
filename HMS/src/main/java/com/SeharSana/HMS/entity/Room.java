package com.SeharSana.HMS.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.stereotype.Component;


@Entity
@Table(name="room")
@Component
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    @Column(name = "room_no",nullable = false, unique = true)
    private Long  roomNumber;
    @Column(name = "beds", nullable = false)
    private int beds;
    @Column(name="room_price", nullable = false)
    private long roomPrice;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
    @OneToOne(cascade =CascadeType.ALL)
    private Reservation reservation;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @Column(name = "room_type")
    private int roomType;
    @Column(name ="rooms_type")
    private String roomTypes;
    public Room(){

    }

    public void setRoomType(int roomType) {
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
}
