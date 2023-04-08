package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;
    @Transactional
    public GuestModel saveGuest(GuestModel guestModel)
    {
        Guest guest = null;
        if (!ObjectUtils.isEmpty(guestModel))
        {
            guest = findExistingGuest(guestModel);
            if (ObjectUtils.isEmpty(guest)) {
                guest = guestModel.disassemble();
            } else
            {
                guest.setEmail(guestModel.getGuestEmail());
            }

        }
        return new GuestModel(guestRepository.save(guest));
    }
    public List<GuestModel> findGuest(Long guestId, String guestEmail) {
        List<GuestModel> guestModels = new ArrayList<>();
        if (guestId != null)
        {
            guestModels = List.of(guestRepository.findAll()
                    .stream()
                    .map(GuestModel::new)
                    .filter(guestModel -> guestModel.getGuestId().equals(guestId))
                    .findFirst()
                    .get());
        }
        else if (guestEmail != null)
        {
            guestModels = List.of(guestRepository.findAll()
                    .stream()
                    .map(GuestModel::new)
                    .filter(guestModel -> guestModel.getGuestEmail().equalsIgnoreCase(guestEmail))
                    .findFirst()
                    .get());
        }
        else
        {

            guestModels = guestRepository.findAll()
                    .stream()
                    .map(GuestModel::new)
                    .collect(Collectors.toList());

        }
        return guestModels;
    }

    private Guest findExistingGuest(GuestModel guestModel)
    {
        Guest guest=null;
        if (!ObjectUtils.isEmpty(guestModel.getGuestId()))
        {
            guest = guestRepository.findGuestById(guestModel.getGuestId());
        }
        else if (!ObjectUtils.isEmpty(guestModel.getGuestEmail()))
        {
            guest = guestRepository.findGuestByEmail(guestModel.getGuestEmail());
        }
        return guest;
    }
    public void deleteGuest(long guestId){
        guestRepository.deleteById(guestId);

    }


}


