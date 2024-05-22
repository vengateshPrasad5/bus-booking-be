package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Dto.BookingDTO;
import com.busbookingbe.app.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM booking  WHERE reservation_date = ?1",
    nativeQuery = true)
    List<Booking> findByReservationDate(String reservationDate);

}
