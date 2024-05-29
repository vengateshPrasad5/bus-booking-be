package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

//    @Query(value = "SELECT * FROM bus WHERE source = :source AND " +
//            "destination = :destination AND DATE(departure_time) = :departureDate",
//            nativeQuery = true)
    List<Bus> findBySourceAndDestinationAndDepartureTime(
            String source,
            String destination,
            Date departureTime);

    @Query("SELECT DISTINCT source FROM Bus")
    List<String> findDistinctSource();

    @Query("SELECT DISTINCT destination FROM Bus")
    List<String> findDistinctDestination();

}
