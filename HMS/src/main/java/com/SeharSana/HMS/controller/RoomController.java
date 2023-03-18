package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.model.RoomModel;
import com.SeharSana.HMS.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping("/roomInfo")
    public RoomModel save(@RequestBody RoomModel roomModel){
        return roomService.roomInfo(roomModel);

    }
}
