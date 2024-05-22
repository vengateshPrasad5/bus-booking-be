package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Dto.PassengerDTO;
import com.busbookingbe.app.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    @Query(value = "SELECT * from passenger p WHERE p.customer_id = :customerId ",
           nativeQuery = true)
    List<PassengerDTO> findByPassengerCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT p FROM Passenger p WHERE p.user.userId = ?1")
    List<Passenger> findByCustomerId(Long userId);
}
