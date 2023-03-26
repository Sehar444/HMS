package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.model.GuestModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepo;

//    public GuestModel saveGuest(GuestModel guestModel) {
//        return guestModel.assemble(guestRepo.save(guestModel.disassemble()));
//    }

    //save guest info by name and ID

    @Transactional
    public GuestModel saveGuest(GuestModel guestModel) {
        Guest guest = null;
        if (!ObjectUtils.isEmpty(guestModel)) {
            guest = findExistingGuest(guestModel);
            if (ObjectUtils.isEmpty(guest)) {
                guest = guestModel.disassemble();
            } else {
                guest.setId(guest.getId());
            }

        }
        return new GuestModel(guestRepo.save(guest));
    }


    private Guest findExistingGuest(GuestModel guestModel) {
        Guest guest=null;
        if (!ObjectUtils.isEmpty(guestModel.getGuestId())) {
            guest = guestRepo.findGuestById(guestModel.getGuestId());
        } else if (!StringUtils.isEmpty(guestModel.getGuestCnic())) {
            guest = guestRepo.findGuestByCnic(guestModel.getGuestCnic());
        }
        return guest;
    }
//
//
    public List<GuestModel> findGuest(Long guestId, Long guestCnic) {
        List<GuestModel> guestModels = new ArrayList<>();
        if (guestId != null) {
            guestModels = List.of(guestRepo.findAll()
                    .stream()
                    .map(GuestModel::new)
                    .filter(guestModel -> guestModel.getGuestId().equals(guestId))
                    .findFirst()
                    .get());
        } else if (guestCnic != null) {
            guestModels = List.of(guestRepo.findAll()
                    .stream()
                    .map(GuestModel::new)
                    .filter(guestModel -> guestModel.getGuestCnic().equals(guestCnic))
                    .findFirst()
                    .get());
        } else

            guestModels = guestRepo.findAll()
                    .stream()
                    .map(GuestModel::new)
                    .collect(Collectors.toList());

        return guestModels;
    }
}


