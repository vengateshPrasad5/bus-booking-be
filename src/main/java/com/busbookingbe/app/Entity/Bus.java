package com.busbookingbe.app.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long busId;
    private String name;
    private String source;
    private String destination;
    @Column(name = "departure_time")
    @Temporal(TemporalType.DATE)
    private Date departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    private long price;
    @Column(name = "bus_type")
    private String busType;
    @Column(name = "no_of_seats")
    private int numberOfSeats;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Seat> seats;

//    @OneToMany(mappedBy = "bus" , cascade = CascadeType.ALL)
//    private List<Seat> seat;

//    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
//    private List<Booking> bookings;

}
