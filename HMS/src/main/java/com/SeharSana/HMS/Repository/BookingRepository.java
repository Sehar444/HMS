package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findByCheckInDate(LocalDate checkInDate);

    List<Booking> findByCheckOutDate(LocalDate checkOutDate);
}
