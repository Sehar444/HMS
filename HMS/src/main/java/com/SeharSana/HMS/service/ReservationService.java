package com.SeharSana.HMS.service;


import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.Repository.ReservationRepository;
import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.model.ReservationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private GuestRepository guestRepo;
    public ReservationModel CheckInout(ReservationModel reservationModel) {
        return reservationModel.assemble(reservationRepository.save(reservationModel.disassemble()));

    }
    public List<Reservation> getGuest() {
        return reservationRepository.findAll();
}}
