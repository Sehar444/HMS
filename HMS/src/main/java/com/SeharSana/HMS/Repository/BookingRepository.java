package com.SeharSana.HMS.Repository;

import com.SeharSana.HMS.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
