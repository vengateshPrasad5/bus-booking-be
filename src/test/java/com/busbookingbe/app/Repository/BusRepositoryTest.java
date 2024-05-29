package com.busbookingbe.app.Repository;

import com.busbookingbe.app.Entity.Booking;
import com.busbookingbe.app.Entity.Bus;
import com.busbookingbe.app.Respository.BusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BusRepositoryTest {

    private Bus bus;
    private Bus bus1;

    @Autowired
    BusRepository busRepository;

    @BeforeEach
    public void initMocks(){
        bus = new Bus();
        bus1 = new Bus();

        bus.setBusId(1L);
        bus.setName("ParveenTravels");
        bus.setSource("Chennai");
        bus.setDestination("Bangalore");
        bus.setArrivalTime("2024-05-24 21:40:00");
        bus.setDepartureTime("2024-05-23 06:40:00");
        bus.setPrice(600L);
        bus.setBusType("Sleeper");
        bus.setNumberOfSeats(36);

        bus1.setBusId(2L);
        bus1.setName("KPNTravels");
        bus1.setSource("Chennai");
        bus1.setDestination("Bangalore");
        bus1.setArrivalTime("2024-05-24 21:40:00");
        bus1.setDepartureTime("2024-05-23 06:40:00");
        bus1.setPrice(600L);
        bus1.setBusType("Sleeper");
        bus1.setNumberOfSeats(36);
    }

    @Test
    public void givenBusObject_whenSave_thenReturnSavedBus(){

        //assert response
        assertThat(busRepository.save(bus)).isNotNull();
        assertThat(busRepository.save(bus).getBusId()).isGreaterThan(0);
    }
    @Test
    public void whenFindAll_thenReturnBusList(){

        busRepository.save(bus);
        busRepository.save(bus1);
        List<Bus> bookingList = busRepository.findAll();
        assertThat(bookingList).isNotNull();
        assertThat(bookingList.size()).isEqualTo(2);
    }

    @Test
    public void whenFindSource_thenReturnSourceList(){
        busRepository.save(bus);
        busRepository.save(bus1);
        List<String> sourceList = busRepository.findDistinctSource();

        assertThat(sourceList).isNotNull();
        assertThat(sourceList).doesNotHaveDuplicates();
        assertThat(sourceList).hasSizeGreaterThan(0);
    }

    @Test
    public void whenFindDestination_thenReturnDestinationList(){
        busRepository.save(bus);
        busRepository.save(bus1);
        List<String> sourceList = busRepository.findDistinctDestination();

        assertThat(sourceList).isNotNull();
        assertThat(sourceList).doesNotHaveDuplicates();
        assertThat(sourceList).hasSizeGreaterThan(0);
    }

    @Test
    public void whenFindBus_thenReturnFilteredBusList(){
        busRepository.save(bus);
        busRepository.save(bus1);
        String dateString  = "2024-05-23";
        LocalDate date = LocalDate.parse(dateString);
        List<Bus> sourceList = busRepository.findBySourceDestinationAndDepartureDate("Chennai","Bangalore", dateString);
        assertThat(sourceList).isNotNull();
        assertThat(sourceList).hasSizeGreaterThan(0);
    }

    @Test
    public void whenFindBus_thenReturnEmptyBusList(){
        busRepository.save(bus);
        busRepository.save(bus1);
        String dateString  = "2024-05-25";
        LocalDate date = LocalDate.parse(dateString);
        List<Bus> sourceList = busRepository.findBySourceDestinationAndDepartureDate("Madurai","Bangalore", dateString);
        assertThat(sourceList).isEmpty();
    }
}
