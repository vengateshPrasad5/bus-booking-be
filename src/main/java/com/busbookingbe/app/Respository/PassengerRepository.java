package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    @Query(value = "SELECT * from passenger p WHERE p.customer_id = :customerId ",
           nativeQuery = true)
    List<Objects> findByPassengerCustomerId(@Param("customerId") Long customerId);
}
