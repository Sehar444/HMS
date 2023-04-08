package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            , @RequestParam(name = "guestCnic",required = false) String guestEmail)
    {
        return guestService.findGuest(guestId,guestEmail);
    }
    @GetMapping("/id/{guestId}" )
    public List<GuestModel> getGuestById(@PathVariable(value = "guestId") Long guestId)
    {
        return guestService.findGuest(guestId,null);

    }
    @DeleteMapping("/{id}")
    public void deleteGuest(long guestId){
        guestService.deleteGuest(guestId);
    }


}