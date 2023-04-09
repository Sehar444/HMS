package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController
{
    @Autowired
    GuestService guestService;
    @PostMapping("/save")
    public GuestModel saveGuest(@RequestBody GuestModel guestModel)
    {

        return guestService.saveGuest(guestModel);
    }
    @GetMapping("/list")
    public List<GuestModel> getGuest(@RequestParam(name = "guestId",required = false) Long guestId
            , @RequestParam(name = "guestEmail",required = false) String guestEmail)
    {
        List<Guest> gusetList = guestService.findGuest(guestId, guestEmail);
        List<GuestModel> guestModelList = new ArrayList<>();
        for (Guest guest : gusetList) {
            guestModelList.add(new GuestModel(guest));
        }
        return guestModelList;
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long guestId){
        guestService.deleteGuest(guestId);
    }


}