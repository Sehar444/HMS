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
import java.util.Optional;

@RestController
@RequestMapping( "/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/save")
    public ResponseEntity <RoomModel> saveRoom(@RequestBody RoomModel roomModel){
        RoomModel savedRoom=roomService.createRoom(roomModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRoom);
    }

        @GetMapping("/{roomId}")
        public ResponseEntity<RoomModel> getRoom(@PathVariable Long roomId) {
            Optional<RoomModel> optionalRoom
                    = Optional.ofNullable(roomService.getRoomById(roomId));
            if (optionalRoom.isPresent()) {
                RoomModel room = optionalRoom.get();
                return ResponseEntity.ok().body(room);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    @GetMapping("/AllRooms")
    public List<Room> getaAllRoomsList(){
        return roomService.findAllRooms();
    }
    @GetMapping("/available")
    public List<Room> getAvailableRooms(@RequestParam EnRoomType roomType) {
        return roomService.findAvailableRoomsByType(roomType);
    }

    @GetMapping("/{roomId}/availability")
    public ResponseEntity<Boolean> isRoomAvailable(@PathVariable Long roomId) {
        RoomModel roomModel = roomService.getRoomById(roomId);
        if (roomModel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boolean isAvailable = roomService.isRoomAvailable(roomModel.assemble(new Room()));
        return new ResponseEntity<>(isAvailable, HttpStatus.OK);
    }


        @PutMapping("/{roomId}")
        public ResponseEntity<RoomModel> updateRoom(@PathVariable Long roomId, @RequestBody RoomModel roomModel) {
            Optional<RoomModel> optionalRoom = Optional.ofNullable(roomService.getRoomById(roomId));

            if (optionalRoom.isPresent()) {
                RoomModel existingRoom = optionalRoom.get();
                existingRoom.setRoomNumber(roomModel.getRoomNumber());
                existingRoom.setBeds(roomModel.getBeds());
                existingRoom.setRoomPrice(roomModel.getRoomPrice());
                existingRoom.setEnRoomType(roomModel.getEnRoomType());
                existingRoom.setHotelModel(roomModel.getHotelModel());
                existingRoom.setReservationModel(roomModel.getReservationModel());

                RoomModel updatedRoom = roomService.updateRoom(existingRoom);
                return ResponseEntity.ok().body(updatedRoom);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{roomId}")
        public ResponseEntity<Void> deleteRoom(@PathVariable Long roomId) {
            Optional<RoomModel> optionalRoom = Optional.ofNullable(roomService.getRoomById(roomId));

            if (optionalRoom.isPresent()) {
                roomService.deleteRoom(roomId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    }
