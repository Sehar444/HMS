package com.SeharSana.HMS.controller;

import com.SeharSana.HMS.entity.Booking;
import com.SeharSana.HMS.model.BookingModel;
import com.SeharSana.HMS.service.BookingService;
import com.SeharSana.HMS.service.GuestService;
import com.SeharSana.HMS.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private GuestService guestService;
        @PostMapping("/createBooking")
        public ResponseEntity<BookingModel> createBooking(
                @RequestParam Long guestId,
                @RequestParam Long roomId,
                @RequestParam String checkInDate,
                @RequestParam String checkOutDate
        ) {
            BookingModel bookingModel = bookingService.createBooking(guestId, roomId, checkInDate, checkOutDate);
            return ResponseEntity.ok(bookingModel);
        }

        @GetMapping("/findBooking")
        public ResponseEntity<List<Booking>> findBookings(
                @RequestParam(required = false) Long bookingId,
                @RequestParam(required = false) String checkInDate,
                @RequestParam(required = false) String checkOutDate) {
            List<Booking> bookings = bookingService.findBooking(bookingId, checkInDate, checkOutDate);
            return ResponseEntity.ok(bookings);
        }

        @PostMapping("/{bookingId}/confirm")
        public ResponseEntity<BookingModel> confirmBooking(@PathVariable BookingModel bookingId) {
            BookingModel booking = bookingService.confirmBooking(bookingId);
            return ResponseEntity.ok(booking);
        }
    }


