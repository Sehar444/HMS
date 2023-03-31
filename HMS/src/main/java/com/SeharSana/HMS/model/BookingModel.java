package com.SeharSana.HMS.model;

import com.SeharSana.HMS.entity.Booking;
import com.SeharSana.HMS.entity.Guest;
import lombok.Data;
import org.springframework.format.datetime.standard.DateTimeContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Component
@Data
public class BookingModel {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime estimatedCheckInTime;
    private GuestModel guestModel;
    private RoomModel roomModel;


    public Booking disassemble() {
        Booking booking = new Booking();
        booking.getId();
        booking.getCheckInDate();
        booking.getCheckOutDate();
        booking.getEstimatedCheckInTime();

        return booking;
    }

    public BookingModel assemble(Booking booking) {
        BookingModel bookingModel = new BookingModel();
        bookingModel.setBookingId(booking.getId());
        bookingModel.setBookingId(booking.getId());
        bookingModel.setCheckInDate(booking.getCheckInDate());
        bookingModel.setEstimatedCheckInTime(booking.getEstimatedCheckInTime());
        return bookingModel;
    }

    public long totalNights() {
        if (checkInDate == null || checkOutDate == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public Optional<ValidationError> validate(LocalDate now) {
        if (checkInDate == null) {
            return Optional.of(new ValidationError("checkInDate.missing", "Missing check in date"));
        } else if (checkOutDate == null) {
            return Optional.of(new ValidationError("checkOutDate.missing", "Missing check out date"));
        } else if (checkInDate.isBefore(now)) {
            return Optional.of(new ValidationError("checkInDate.future", "Check in date must be in the future"));
        } else if (checkOutDate.isBefore(checkInDate)) {
            return Optional.of(new ValidationError("checkOutDate.afterCheckIn", "Check out date must occur after check in date"));
        } else if (totalNights() < 1) {
            // handles case where check in/out dates are the same.
            return Optional.of(new ValidationError("checkOutDate.minNights", "Reservation must be for at least 1 night"));
        }
        return Optional.empty();
    }
}
