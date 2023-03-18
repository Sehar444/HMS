package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public RoomModel roomInfo(RoomModel roomModel){
        return roomModel.assemble(roomRepository.save(roomModel.disassemble()));
    }

}
