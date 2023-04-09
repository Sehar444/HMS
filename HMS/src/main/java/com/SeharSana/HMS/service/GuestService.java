package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestService {
        @Autowired
        public GuestRepository guestRepository;
        public GuestModel saveGuest(GuestModel guestModel){
            return guestModel.assemble(guestRepository.save(guestModel.disassemble()));
        }

        public List<Guest> findGuest(Long guestId, String guestEmail) {
            if (guestId != null && guestEmail != null) {
                guestRepository.findGuestByIdAndEmail(guestId, guestEmail);
            } else if (guestId != null) {
                guestRepository.findGuestById(guestId);
            } else if (guestEmail != null) {
                guestRepository.findGuestByEmail(guestEmail);
            }
            return guestRepository.findAll();
        }

        public void deleteGuest(Long gusetId) {
            GuestModel guest = guestRepository.findGuestById(gusetId)
                            .orElseThrow("Guest Not Found");
            guestRepository.delete(guest.disassemble( ));

        }


}


