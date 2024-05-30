package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query(value = "SELECT * FROM bus WHERE source =:source AND " +
            "destination =:destination AND departure_date =:departureDate",
            nativeQuery = true)
    List<BusDTO> findBySourceAndDestinationAndDepartureDate(
            @Param("source") String source ,
            @Param("destination") String destination,
            @Param("departureDate") LocalDate departureTime);

    @Query("SELECT DISTINCT source FROM Bus")
    List<String> findDistinctSource();

    @Query("SELECT DISTINCT destination FROM Bus")
    List<String> findDistinctDestination();

}
