package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {

    @Query("SELECT b FROM Bus b WHERE b.source = :source AND b.destination = :destination AND DATE(b.departureTime) = :departureDate")
    List<Bus> findBySourceDestinationAndDepartureDate(
            @Param("source") String source,
            @Param("destination") String destination,
            @Param("departureDate") String departureDate);
}
