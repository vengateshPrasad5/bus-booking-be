package com.busbookingbe.app.Repository;

import com.busbookingbe.app.Entity.*;
import com.busbookingbe.app.Respository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookingRepositoryTest {

    private Booking booking;
    private Booking booking1;

    @Autowired
    private BookingRepository bookingRepository;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this); //to initialize your mocks

        booking =  new Booking();
        booking1 =  new Booking();
        User user = new User();
        Bus bus = new Bus();
        Passenger passenger = new Passenger();
        Passenger passenger1 = new Passenger();
        Passenger passenger2 = new Passenger();

        Seat seat = new Seat();
        Seat seat1 = new Seat();
        Seat seat2 = new Seat();

        List<Passenger> passengerList = List.of(passenger,passenger1);

        List<Passenger> passengerList1 = List.of(passenger2);



        user.setUserId(1L);
        user.setUserName("John");
        user.setEmailId("email@example.com");
        user.setPassword("12334");

        bus.setBusId(1L);
        bus.setName("ParveenTravels");
        bus.setSource("Chennai");
        bus.setDestination("Bangalore");
        bus.setArrivalTime("2024-05-22 21:40:00");
        bus.setDepartureTime("2024-05-23 06:40:00");
        bus.setPrice(600L);
        bus.setBusType("Sleeper");
        bus.setNumberOfSeats(36);

        passenger.setPassengerId(1L);
        passenger.setName("jo");
        passenger.setAge(22);
        passenger.setSeat(seat);
        passenger.setGender("Male");
        passenger.setUser(user);
        passenger.setBooking(booking);

        passenger1.setPassengerId(2L);
        passenger1.setName("jill");
        passenger1.setAge(22);
        passenger1.setSeat(seat1);
        passenger1.setGender("Female");
        passenger1.setUser(user);
        passenger1.setBooking(booking);

        passenger2.setPassengerId(3L);
        passenger2.setName("jill");
        passenger2.setAge(22);
        passenger2.setSeat(seat2);
        passenger2.setGender("Female");
        passenger2.setUser(user);
        passenger2.setBooking(booking);

        seat.setSeatId(1L);
        seat.setSeatNo("U1");
        seat.setHeight(1);
        seat.setBusRow(11);

        seat1.setSeatId(2L);
        seat1.setSeatNo("U2");
        seat1.setHeight(1);
        seat1.setBusRow(12);

        seat2.setSeatId(3L);
        seat2.setSeatNo("U3");
        seat2.setHeight(1);
        seat2.setBusRow(13);

        booking.setBookingId(1L);
        booking.setReservationDate("2024-05-22");
        booking.setStatus("Confirmed");
        booking.setUser(user);
        booking.setBus(bus);
        booking.setPassengerList(passengerList);

        booking1.setBookingId(2L);
        booking1.setReservationDate("2024-05-23");
        booking1.setStatus("Cancelled");
        booking1.setUser(user);
        booking1.setBus(bus);
        booking1.setPassengerList(passengerList1);
    }
    @Test
    public void givenBookingObject_whenSave_thenReturnSavedEmployee(){

        //assert response
        assertThat(bookingRepository.save(booking)).isNotNull();
        assertThat(bookingRepository.save(booking).getBookingId()).isGreaterThan(0);
    }
   @Test
   public void whenFindAll_thenReturnBookingList(){

       bookingRepository.save(booking);
       bookingRepository.save(booking1);
       List<Booking> bookingList = bookingRepository.findAll();
       assertThat(bookingList).isNotNull();
       assertThat(bookingList.size()).isEqualTo(2);
   }
}
