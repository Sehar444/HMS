package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.model.RoomModel;
import com.SeharSana.HMS.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/room")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping("/save")
    public RoomModel save(@RequestBody RoomModel roomModel)
    {
        return roomService.saveRoom(roomModel);

    }
    @GetMapping("/list")
    public List<RoomModel> getRoom(@RequestParam(name = "roomNumber",required = false) Long roomNumber)
    {
        return roomService.findRoom(roomNumber);
    }
    @GetMapping("/roomNumber/{roomNumber}" )
    public List<RoomModel> getRoomById(@PathVariable(value = "roomNumber") Long roomNumber)
    {
        return roomService.findRoom(roomNumber);
    }
}
