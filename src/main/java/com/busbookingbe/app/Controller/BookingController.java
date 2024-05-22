package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.BookingDTO;
import com.busbookingbe.app.Service.ServiceImpl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {
    @Autowired
    BookingServiceImpl bookingServiceImpl;

    @GetMapping("/getBookingList")
    public ResponseEntity<List<BookingDTO>>findByBookingList(@RequestParam String reservationDate) {
        List<BookingDTO> bookingList = bookingServiceImpl.getBookingByReservationDate(reservationDate);
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }

    @PostMapping("/createBooking")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO booking = bookingServiceImpl.createBooking(bookingDTO);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}