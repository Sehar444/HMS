package com.SeharSana.HMS.model;


import com.SeharSana.HMS.entity.Room;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoomModel {

    private long roomNo;
    private long roomPrice;


    public Room disassemble(){
        Room room=new Room();
        room.setRoomNo(roomNo);
        room.setRoomPrice(roomPrice);
        return room;
    }
    public RoomModel assemble(Room room){
        RoomModel roomModel=new RoomModel();
        roomModel.setRoomNo(room.getRoomNo());
        roomModel.setRoomPrice(room.getRoomPrice());
        return roomModel;
    }
//    public RoomModel(long roomNo, long roomPrice, long guestId){
//        this.roomNo=roomNo;
//        this.roomPrice=roomPrice;
//        this.guestModel=new GuestModel(guestId);
//
//    }
//    public RoomModel(Room room){
//        this.roomNo=room.getRoomNo();
//        this.roomPrice=room.getRoomPrice();
//        this.guestModel=new GuestModel(room.getGuest());
//    }
}
