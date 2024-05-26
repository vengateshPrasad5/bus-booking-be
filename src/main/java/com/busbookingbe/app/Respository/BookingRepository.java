package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM booking  WHERE reservation_date = ?1",
    nativeQuery = true)
    List<Booking> findByReservationDate(String reservationDate);

}
