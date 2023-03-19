package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Room;
import com.SeharSana.HMS.model.GuestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepo;
    @Autowired
    private RoomRepository roomRepository;

    Guest guest=null;

//    public GuestModel guestInfo(GuestModel guestModel) {
//     return  guestModel.assemble(guestRepo.save(guestModel.disassemble()));
//
//    }
    public GuestModel guestInfo (GuestModel guestModel){
      if(!guest.getGuestName().isEmpty()){
          guest.setGuestName(guestModel.getGuestName());
      }
      else {
          guest.setGuestId(guestModel.getGuestId());
      }

      return guestModel;
    }

    public List<Guest> getGuest() {
        return guestRepo.findAll();

    }
}
