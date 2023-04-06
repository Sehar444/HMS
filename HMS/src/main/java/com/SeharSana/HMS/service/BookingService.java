package com.SeharSana.HMS.service;

import com.SeharSana.HMS.Repository.BookingRepository;
import com.SeharSana.HMS.Repository.GuestRepository;
import com.SeharSana.HMS.Repository.RoomRepository;
import com.SeharSana.HMS.entity.Booking;
import com.SeharSana.HMS.exception.GuestNotFoundException;
import com.SeharSana.HMS.exception.RoomAlreadyBookedException;
import com.SeharSana.HMS.exception.RoomNotFoundException;
import com.SeharSana.HMS.model.BookingModel;
import com.SeharSana.HMS.model.GuestModel;
import com.SeharSana.HMS.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;


@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, GuestRepository guestRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
    }


    public BookingModel createBooking(Long guestId, Long roomId
            , LocalDate checkInDate, LocalDate checkOutDate) {
        GuestModel guestModel = guestRepository.findGuestById(guestId)
                .orElseThrow(String.valueOf(new GuestNotFoundException("Guest Not Found")));
        RoomModel roomModel = roomRepository.findRoomByRoomNumber(roomId)
                .orElseThrow(new RoomNotFoundException("Room Not Found"));
        boolean isRoomReserved = roomRepository.findRoomByRoomType(roomModel.getRoomTypes()).isReserved;
        if (!isRoomReserved) {
            BookingModel bookingModel = new BookingModel();
            bookingModel.setGuestModel(guestModel);
            bookingModel.setRoomModel(roomModel);
            bookingModel.setCheckInDate(checkInDate);
            bookingModel.setCheckOutDate(checkOutDate);
            roomModel.setReserved(true);
            roomRepository.save(roomModel);
            bookingRepository.save(bookingModel);
            return bookingModel;
        } else {
            throw new RoomAlreadyBookedException("Room is already booked");
        }
    }
    public List<Booking> findBooking(Long bookingId, LocalDate checkInDate
            , LocalDate checkOutDate)
    {
        List<Booking> bookingModels;
        if (bookingId != null) {
            bookingModels = bookingRepository.findById(bookingId)
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
        }
        else if(checkInDate !=null){
            bookingModels = bookingRepository.findByCheckInDate(checkInDate);
        } else if (checkOutDate != null) {
            bookingModels=bookingRepository.findByCheckOutDate(checkOutDate);
        }
        else{
            bookingModels=bookingRepository.findAll();
        }
        return bookingModels;
    }

    public BookingModel confirmBooking(BookingModel bookingModel) {
        return bookingRepository.save(bookingModel);
//        return bookingModel.assemble(bookingRepository.save(bookingModel.disassemble()));
    }
//    public long totalNights() {
//        if (checkInDate == null || checkOutDate == null) {
//            return 0;
//        } else {
//            return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
//        }
//    }
//
//
//    public Optional<ValidationError> validate(LocalDate now) {
//        if (checkInDate == null) {
//            return Optional.of(new ValidationError("checkInDate.missing", "Missing check in date"));
//        } else if (checkOutDate == null) {
//            return Optional.of(new ValidationError("checkOutDate.missing", "Missing check out date"));
//        } else if (checkInDate.isBefore(now)) {
//            return Optional.of(new ValidationError("checkInDate.future", "Check in date must be in the future"));
//        } else if (checkOutDate.isBefore(checkInDate)) {
//            return Optional.of(new ValidationError("checkOutDate.afterCheckIn", "Check out date must occur after check in date"));
//        } else if (totalNights() < 1) {
//            // handles case where check in/out dates are the same.
//            return Optional.of(new ValidationError("checkOutDate.minNights", "Reservation must be for at least 1 night"));
//        }
//        return Optional.empty();
//    }
}
