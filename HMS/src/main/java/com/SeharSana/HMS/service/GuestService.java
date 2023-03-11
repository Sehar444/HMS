package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepo;

    public  Guest guestInfo(Guest guest) {
        return guestRepo.save(guest);
    }

}
