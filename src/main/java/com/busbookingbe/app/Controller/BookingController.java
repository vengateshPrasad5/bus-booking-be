package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.BookingDTO;
import com.busbookingbe.app.Exception.ResourceNotFoundException;
import com.busbookingbe.app.Service.ServiceImpl.BookingServiceImpl;
import com.razorpay.RazorpayException;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
@CrossOrigin(origins = {"*","http://127.0.0.1:5173/"})
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired
    BookingServiceImpl bookingServiceImpl;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/getBookingListByDate")
    public ResponseEntity<List<BookingDTO>>findByBookingList(@RequestParam String reservationDate) {
        try {
            List<BookingDTO> bookingList = bookingServiceImpl.getBookingByReservationDate(reservationDate);
            return new ResponseEntity<>(bookingList, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("BookingList Not Found");
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PostMapping("/createBooking")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        try {
            BookingDTO booking = bookingServiceImpl.createBooking(bookingDTO);
            return new ResponseEntity<>(booking, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Booking Unsuccessful!!!");
        }
    }
}
