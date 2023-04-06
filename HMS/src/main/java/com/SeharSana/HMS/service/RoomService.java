package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.entity.Room;
import com.SeharSana.HMS.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public RoomModel createRoom(RoomModel roomModel) {
        return roomModel.assemble(roomRepository.save(roomModel.disassemble()));
    }
    public RoomModel updateRoom(RoomModel roomModel) {
        Optional<Room> optionalRoom = roomRepository.findById(roomModel.getRoomId());
        if (optionalRoom.isPresent()) {
//            Room room = optionalRoom.get();
//            roomModel.assemble(room);
//            Room updatedRoom = roomRepository.save(room);
//            return new RoomModel(updatedRoom);
            return roomModel.assemble(roomRepository.save(updateRoom(roomModel)));
        }
        return null;
    }
    public RoomModel getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return new RoomModel(room);
    }


    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }


    public List<Room> findAvailableRoomsByType(EnRoomType roomType) {
        return roomRepository.findByRoomTypeAndReservationIsNull(roomType);
    }

    public boolean isRoomAvailable(RoomModel roomModel) {
        return roomRepository.findByRoomNumberAndReservationIsNull(roomModel.getRoomNumber()).isPresent();
    }
    public void deleteRoom(Long id)  {
        roomRepository.deleteById(id);

    }
}
