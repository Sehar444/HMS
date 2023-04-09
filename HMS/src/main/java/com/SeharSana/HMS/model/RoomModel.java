package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoomModel  {
    private Long roomId;
    private Long roomNumber;
    private int beds;
    private long roomPrice;
    private String enRoomType;

    public static boolean isReserved;

    public Room disassemble()
    {
        Room npRoom = new Room();
        npRoom.setId(this.getRoomId());
        npRoom.setRoomNumber(this.getRoomNumber());
        npRoom.setBeds(this.getBeds());
        npRoom.setRoomPrice(this.getRoomPrice());
        npRoom.isReserved();
        npRoom.setReservation(npRoom.getReservation( ));
        npRoom.setEnRoomType(this.getEnRoomType());
        return npRoom;
    }
    public RoomModel assemble(Room room)
    {
        RoomModel roomModel = new RoomModel(room);
        roomModel.setRoomId(room.getId());
        roomModel.setRoomNumber(room.getRoomNumber());
        roomModel.setBeds(room.getBeds());
        roomModel.setRoomPrice(room.getRoomPrice());
        roomModel.setEnRoomType(room.getEnRoomType());
        return roomModel;
    }
    public RoomModel(Room room)
    {

        this.roomId=room.getId();
        this.roomNumber=room.getRoomNumber();
        this.beds=room.getBeds();
        this.enRoomType=room.getEnRoomType();

    }
    public RoomModel(){

    }
}
