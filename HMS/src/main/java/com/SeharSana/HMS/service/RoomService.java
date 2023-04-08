package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.Utility.EnRoomType;
import com.SeharSana.HMS.entity.Room;
import com.SeharSana.HMS.exception.RoomNotFoundException;
import com.SeharSana.HMS.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService
{
    @Autowired
    private RoomRepository roomRepository;
    public RoomModel createRoom(RoomModel roomModel)
    {
        return roomModel.assemble(roomRepository.save(roomModel.disassemble()));
    }
    public RoomModel updateRoom(RoomModel roomModel)
    {
        Optional<Room> optionalRoom = roomRepository.findById(roomModel.getRoomId());
        if (optionalRoom.isPresent())
        {
            return roomModel.assemble(roomRepository.findRoomByEnRoomType(roomModel.getEnRoomType()));
        }
        return null;
    }
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow( ()-> new RoomNotFoundException("Room Not Found") );
    }


    public List<Room> findAllRooms()
    {
        return roomRepository.findAll();
    }


    public List<Room> findAvailableRoomsByType(EnRoomType roomType)
    {
        return roomRepository.findByRoomTypeAndReservationIsNull(roomType);
    }

    public boolean isRoomAvailable(Room room)
    {
        return roomRepository.findByRoomNumberAndReservationIsNull
                (room.getRoomNumber()).isPresent();
    }
    public void deleteRoom(Long id)
    {
        roomRepository.deleteById(id);

    }
}
