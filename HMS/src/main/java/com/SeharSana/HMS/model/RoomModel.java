package com.SeharSana.HMS.model;


import com.SeharSana.HMS.Utility.RoomType;
import com.SeharSana.HMS.entity.Hotel;
import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Data
public class RoomModel {

    private Long id;
    private Long roomNumber;
    private int beds;
    private long roomPrice;
    private Hotel hotel;
    private ReservationModel reservationModel;
    private RoomType roomType;


    public Room disassemble() {
        Room npRoom = new Room();
        npRoom.setId(this.getId());
        npRoom.setRoomNumber(this.getRoomNumber());
        npRoom.setBeds(this.getBeds());
        npRoom.setRoomPrice(this.getRoomPrice());
        npRoom.setRoomType(this.getRoomType());
        return npRoom;
    }


    public RoomModel(Room room) {
        this.roomNumber = room.getRoomNumber();
        this.beds = room.getBeds();
        this.roomPrice = room.getRoomPrice();
        this.hotel = room.getHotel();
        this.reservationModel =new ReservationModel(room.getReservation());
        this.roomType=room.getRoomType();
    }

}


