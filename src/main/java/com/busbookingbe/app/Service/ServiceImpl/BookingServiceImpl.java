package com.busbookingbe.app.Service.ServiceImpl;

import com.busbookingbe.app.Dto.BookingDTO;
import com.busbookingbe.app.Entity.Booking;
import com.busbookingbe.app.Entity.Passenger;
import com.busbookingbe.app.Respository.BookingRepository;
import com.busbookingbe.app.Respository.BusRepository;
import com.busbookingbe.app.Respository.SeatRepository;
import com.busbookingbe.app.Respository.UserRepository;
import com.busbookingbe.app.Service.BookingService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BusRepository busRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<BookingDTO> getBookingByReservationDate(String reservationDate) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return bookingRepository.findByReservationDate(reservationDate)
                .stream().map(booking ->modelMapper.map(booking, BookingDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setReservationDate(bookingDTO.getReservationDate());
        booking.setStatus(bookingDTO.getStatus());
        booking.setUser(userRepository.findById(bookingDTO.getUserId())
                                      .orElseThrow(()->new RuntimeException("User not found")));
        booking.setBus(busRepository.findById(bookingDTO.getBusId())
                                    .orElseThrow(()->new RuntimeException("Bus not found")));
//        booking.setSeat(seatRepository.findById(bookingDTO.getSeatId()).orElseThrow(()->new RuntimeException("Seat not found")));

//        List<Seat> seatList = bookingDTO.getSeats().stream().map(dto->{
//            Seat seat = new Seat();
//            seat.setSeatId(dto.getSeatId());
//            seat.setSeatNo(dto.getSeatNo());
//            seat.setHeight(dto.getHeight());
//            seat.setBusRow(dto.getBusRow());
//            seat.setBus(booking.getBus());
//            return seat;
//        }).collect(Collectors.toList());
//        booking.setSeats(seatList);
        List<Passenger> passengers = bookingDTO.getPassengerList().stream().map(dto -> {
            Passenger passenger = new Passenger();
            passenger.setName(dto.getName());
            passenger.setAge(dto.getAge());
            passenger.setGender(dto.getGender());
            passenger.setSeat(seatRepository.findById(dto.getSeatId())
                                            .orElseThrow(()->new RuntimeException("Seat Not Found")));
            passenger.setBooking(booking);
            passenger.setUser(booking.getUser());
            return passenger;
        }).collect(Collectors.toList());
        booking.setPassengerList(passengers);
        return modelMapper.map(bookingRepository.save(booking),BookingDTO.class);
    }
}