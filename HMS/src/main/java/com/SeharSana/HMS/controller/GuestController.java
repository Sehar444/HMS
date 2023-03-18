package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;
    @PostMapping("/guestInfo")
    public GuestModel save(@RequestBody GuestModel guestModel) {
        return guestService.guestInfo(guestModel);
    }
    @GetMapping("/AllGuest")
    public List<Guest> getAllGuest() {
        return guestService.getGuest();
    }
}