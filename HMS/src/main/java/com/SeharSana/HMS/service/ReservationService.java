package com.SeharSana.HMS.service;


import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.Repository.PaymentRepository;
import com.SeharSana.HMS.Repository.ReservationRepository;
import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.Utility.ReservationStatus;
import com.SeharSana.HMS.entity.Guest;
import com.SeharSana.HMS.entity.Payment;
import com.SeharSana.HMS.entity.Reservation;
import com.SeharSana.HMS.entity.Room;
import com.SeharSana.HMS.model.PaymentModel;
import com.SeharSana.HMS.model.ReservationModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository,
                              RoomRepository roomRepository, PaymentRepository paymentRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    public ReservationModel createReservation(ReservationModel reservationModel) {
        Reservation reservation = reservationModel.disassemble();
        Guest guest = guestRepository.findById(reservationModel.getGuestId())
                .orElseThrow(() -> new EntityNotFoundException("Guest with ID " + reservationModel.getGuestId() + " not found"));
        Room room = roomRepository.findById(reservationModel.getRoomId())
                .orElseThrow(() -> new EntityNotFoundException("Room with ID " + reservationModel.getRoomId() + " not found"));
        reservation.setGuest(guest);
        reservation.setRoom(room);
        reservation.setStatus(ReservationStatus.PENDING);
        reservation = reservationRepository.save(reservation);
        room.getReservations().add(reservation);
        roomRepository.save(room);
        return new ReservationModel(reservation);
    }

    public ReservationModel getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation with ID " + id + " not found"));
        return new ReservationModel(reservation);
    }

    public List<ReservationModel> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations
                .stream()
                .map(ReservationModel::new)
                .collect(Collectors.toList());
    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        Reservation reservation = reservationRepository.findById(reservationModel.getReservationId())
                .orElseThrow(() -> new EntityNotFoundException("Reservation with ID " + reservationModel.getReservationId() + " not found"));
        if (reservationModel.isCheckIn() && !reservation.isCheckIn()) {
            reservation.setCheckInDate(LocalDate.now());
            reservation.setCheckIn(true);
            reservation.setStatus(ReservationStatus.CHECKED_IN);
        }
        if (reservationModel.isCheckOut() && !reservation.isCheckOut()) {
            reservation.setCheckOutDate(LocalDate.now());
            reservation.setCheckOut(true);
            reservation.setStatus(ReservationStatus.CHECKED_OUT);
        }
        reservation = reservationRepository.save(reservation);
        return new ReservationModel(reservation);
    }

    public void deleteReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation with ID " + id + " not found"));
        Room room = (Room) reservation.getRoom();
        room.getReservations().remove(reservation);
        roomRepository.save(room);
        reservationRepository.deleteById(id);
    }
}


