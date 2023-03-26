package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;
    @PostMapping(path="/GuestInfo")
    public GuestModel save(@RequestBody GuestModel guestModel) {
        return guestService.saveGuest(guestModel);
    }
    @GetMapping(path = "/GuestList")
    public List<GuestModel> getAllGuest(@RequestParam(name = "guestId",required = false) Long guestId, @RequestParam(name = "guestCnic",required = false) Long guestCnic) {
        return guestService.findGuest(guestId,guestCnic);
    }
    @GetMapping(path = "/id/{guestId}" )
    public List<GuestModel> getGuestById(@PathVariable(value = "guestId") Long guestId)
    {
        return guestService.findGuest(guestId,null);
    }



}