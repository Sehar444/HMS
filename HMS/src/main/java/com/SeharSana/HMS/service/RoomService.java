package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.entity.Room;
import com.SeharSana.HMS.model.RoomModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Transactional
    public RoomModel saveRoom(RoomModel roomModel)
    {
        Room room = null;
        if (!ObjectUtils.isEmpty(roomModel))
        {
            room = findExistingRoom(roomModel);
            if (ObjectUtils.isEmpty(room)) {
                room = roomModel.disassemble();
            } else
            {
                room.setRoomNumber(roomModel.getRoomNumber());
            }

        }
        return new RoomModel(roomRepository.save(room));
    }

    public List<RoomModel> findRoom(Long roomNumber) {
        List<RoomModel> roomModels = new ArrayList<>();
        if (roomNumber != null) {
            roomModels = List.of(roomRepository.findAll()
                    .stream()
                    .map(RoomModel::new)
                    .filter(roomModel -> roomModel.getRoomNumber().equals(roomNumber))
                    .findFirst()
                    .get());
        } else {
            roomModels = roomRepository.findAll()
                    .stream()
                    .map(RoomModel::new)
                    .collect(Collectors.toList());
        }

        return roomModels;

    }
    private Room findExistingRoom(RoomModel roomModel)
    {
        Room room=null;
        if (!ObjectUtils.isEmpty(roomModel.getRoomNumber()))
        {
            room = roomRepository.findRoomByRoomNumber(roomModel.getRoomNumber());
        }
        else if (!ObjectUtils.isEmpty(roomModel.getRoomPrice()))
        {
            room = roomRepository.findRoomByRoomPrice(roomModel.getRoomPrice());
        }
        return room;
    }
}
