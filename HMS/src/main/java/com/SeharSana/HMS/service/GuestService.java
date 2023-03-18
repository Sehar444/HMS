package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepo;

    public GuestModel guestInfo(GuestModel guestModel) {
        return guestModel.assemble(guestRepo.save(guestModel.disassemble()));
    }

    public List<Guest> getGuest() {
        return guestRepo.findAll();

    }
}
