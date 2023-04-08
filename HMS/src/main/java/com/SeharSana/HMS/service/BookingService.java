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
    @Autowired
    private  BookingRepository bookingRepository;
    @Autowired
    private  RoomRepository roomRepository;
    @Autowired
    private GuestRepository guestRepository;

    public BookingModel createBooking(Long guestId, Long roomId
            , LocalDate checkInDate, LocalDate checkOutDate)
    {
        GuestModel guestModel = guestRepository.findGuestById(guestId)
                .orElseThrow(String.valueOf(new GuestNotFoundException("Guest Not Found")));
        RoomModel roomModel = roomRepository.findRoomByRoomNumber(roomId)
                .orElseThrow(new RoomNotFoundException("Room Not Found"));
        boolean isRoomReserved = roomRepository.findRoomByEnRoomType(roomModel.getEnRoomType()).isReserved;
        if (!isRoomReserved)
        {
            BookingModel bookingModel = new BookingModel();
            roomModel.assemble(roomRepository.save(roomModel.disassemble()));
            guestRepository.save(guestModel.disassemble());
            bookingModel.assemble(bookingRepository.save(bookingModel.disassemble()));

            return bookingModel;
        } else
        {
            throw new RoomAlreadyBookedException("Room is already booked");
        }
    }
    public List<Booking> findBooking(Long bookingId, LocalDate checkInDate
            , LocalDate checkOutDate)
    {
        List<Booking> bookingModels;
        if (bookingId != null)
        {
            bookingModels = bookingRepository.findById(bookingId)
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
        }
        else if(checkInDate !=null){
            bookingModels = bookingRepository.findByCheckInDate(checkInDate);
        } else if (checkOutDate != null) {
            bookingModels=bookingRepository.findByCheckOutDate(checkOutDate);
        }
        else
        {
            bookingModels=bookingRepository.findAll();
        }
        return bookingModels;
    }
    public BookingModel confirmBooking(BookingModel bookingModel)
    {
        return bookingModel.assemble(bookingRepository.save(bookingModel.disassemble()));

    }
}
