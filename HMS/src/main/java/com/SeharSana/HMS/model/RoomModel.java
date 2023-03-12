package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Room;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoomModel {

    private long roomNo;
    private String roomPrice;
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
}
