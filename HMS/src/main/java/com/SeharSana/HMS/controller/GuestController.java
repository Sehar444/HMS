package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestController {
    @Autowired
    private GuestService guestService;
    @PostMapping("/guestInfo")
    public GuestModel save(@RequestBody GuestModel guestModel) {
        return guestService.guestInfo(guestModel);
    }
}