package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.entity.Room;
import com.SeharSana.HMS.model.RoomModel;
import com.SeharSana.HMS.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping( "/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity<RoomModel> saveRoom(@RequestBody RoomModel roomModel)
    {
        RoomModel savedRoom = roomService.createRoom(roomModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

    @GetMapping("/{roomId}")
    public Room getRoom(@PathVariable Long roomId)
    {
        return roomService.getRoomById(roomId);
    }

    @GetMapping("/AllRooms")
    public List<Room> getaAllRoomsList()
    {
        return roomService.findAllRooms( );
    }

//    @GetMapping("roomType/available")
//    public List<Room> getAvailableRooms(@RequestParam EnRoomType roomType)
//    {
//        return roomService.findAvailableRoomsByType(roomType);
//    }

    @PutMapping("/{roomId}")
    public RoomModel updateRoom(@PathVariable Long roomId, @RequestBody RoomModel roomModel)
    {
        roomModel.setRoomId(roomId);
        return roomService.updateRoom(roomModel);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable Long roomId)
    {
        roomService.deleteRoom(roomId);
    }
}


