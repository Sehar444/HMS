package com.SeharSana.HMS.model;


import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.entity.Room;
import lombok.Data;


@Data
public class RoomModel {

    private Long roomId;
    private Long roomNumber;
    private int beds;
    private long roomPrice;
    private int roomType;
    private String roomTypeStr;
    private HotelModel hotelModel;
    private ReservationModel reservationModel;
    private EnRoomType enRoomType;


    public Room disassemble() {
        Room npRoom = new Room();
        npRoom.setId(this.getRoomId());
        npRoom.setRoomNumber(this.getRoomNumber());
        npRoom.setBeds(this.getBeds());
        npRoom.setRoomPrice(this.getRoomPrice());
        npRoom.setRoomType(this.enRoomType.ordinal());
        npRoom.setRoomType(EnRoomType.BALCONY.toString());
        EnRoomType.BALCONY.getVal();
        return npRoom;
    }


    public RoomModel(Room room) {
        this.roomNumber = room.getRoomNumber();
        this.beds = room.getBeds();
        this.roomPrice = room.getRoomPrice();
        this.hotelModel=new HotelModel();
        this.reservationModel=new ReservationModel(room.getReservation());
    }

    public RoomModel(){

    }
}


