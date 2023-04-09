package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.ReservationRepository;
import com.SeharSana.HMS.entity.Reservation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Lazy
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id)
    {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent( )) {
            return reservation.get( );
        } else
        {
            throw new EntityNotFoundException("Reservation with id " + id + " not found.");
        }
    }

    public Reservation createReservation(Reservation reservation)

    {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, Reservation reservationUpdates)
    {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent( )) {
            Reservation existingReservation = reservation.get( );
            existingReservation.setCheckIn(reservationUpdates.isCheckIn( ));
            existingReservation.setCheckOut(reservationUpdates.isCheckOut( ));
            existingReservation.setStatus(reservationUpdates.getStatus( ));
            existingReservation.setGuest(reservationUpdates.getGuest( ));
            existingReservation.setRoom(reservationUpdates.getRoom( ));
            return reservationRepository.save(existingReservation);
        } else
        {
            throw new EntityNotFoundException("Reservation with id " + id + " not found.");
        }
    }

    public void deleteReservation(Long id)
    {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent( ))
        {
            reservationRepository.deleteById(id);
        } else
        {
            throw new EntityNotFoundException("Reservation with id " + id + " not found.");
        }
    }
}