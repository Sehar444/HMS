package com.SeharSana.HMS.model;

import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.entity.Room;
import lombok.Data;

@Data
public class RoomModel extends  Room {
    private Long roomId;
    private Long roomNumber;
    private int beds;
    private long roomPrice;
    private EnRoomType enRoomType;
    private HotelModel hotelModel;
    private ReservationModel reservationModel;
    private GuestModel guestModel;

    public static boolean isReserved;

    public Room disassemble() {
        Room npRoom = new Room();
        npRoom.setId(this.getRoomId());
        npRoom.setRoomNumber(this.getRoomNumber());
        npRoom.setBeds(this.getBeds());
        npRoom.setRoomPrice(this.getRoomPrice());
        npRoom.isReserved();
        npRoom.setRoomType(String.valueOf(this.getRoomType().ordinal()));
        npRoom.setReservation(npRoom.getReservation( ));
        npRoom.setRoomTypes(getRoomTypes());
        return npRoom;
    }

    public RoomModel(Room room) {
        this.roomId = room.getId();
        this.roomNumber = room.getRoomNumber();
        this.beds = room.getBeds();
        this.roomPrice = room.getRoomPrice();
        this.hotelModel = new HotelModel();
        this.reservationModel=new ReservationModel();
        this.enRoomType = EnRoomType.values( )[room.getRoomType().ordinal()];
        room.isReserved();

    }
    public RoomModel assemble(Room room) {
        RoomModel roomModel = new RoomModel();
        roomModel.setRoomId(room.getId());
        roomModel.setRoomNumber(room.getRoomNumber());
        roomModel.setBeds(room.getBeds());
        roomModel.setRoomPrice(room.getRoomPrice());
        roomModel.setReserved(room.isReserved);
        roomModel.setReservationModel(new ReservationModel());
//        if (room.getGuest() != null) {
//            roomModel.setGuestId(room.getGuest().getId());
//        }
//        if (room.getReservation() != null) {
//            roomModel.setReservationId(room.getReservation().getId());
//        }
        return roomModel;
    }


    public RoomModel() {
    }

    public void setReserved(boolean b) {
    }
}
