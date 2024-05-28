package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query("SELECT b FROM Bus b WHERE b.source = :source AND " +
            "b.destination = :destination AND STR_TO_DATE(DATE(b.departureTime), '%Y-%m-%d')  = :departureDate")
    List<Bus> findBySourceDestinationAndDepartureDate(
            @Param("source") String source,
            @Param("destination") String destination,
            @Param("departureDate") LocalDate departureDate);

    @Query("SELECT DISTINCT source FROM Bus")
    List<String> findDistinctSource();

    @Query("SELECT DISTINCT destination FROM Bus")
    List<String> findDistinctDestination();

}
