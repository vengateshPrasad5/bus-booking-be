package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.BookingDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface BookingService {
    List<BookingDTO> getBookingByReservationDate(String reservationDate);

    BookingDTO createBooking(BookingDTO bookingDTO);

}
