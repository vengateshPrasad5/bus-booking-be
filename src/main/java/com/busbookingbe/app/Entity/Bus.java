package com.busbookingbe.app.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date departureTime;
    @Column(name = "arrival_time")
    private Date arrivalTime;
    private long price;
    @Column(name = "bus_type")
    private String busType;
    @Column(name = "no_of_seats")
    private int numberOfSeats;

//    @OneToMany(mappedBy = "bus" , cascade = CascadeType.ALL)
////    @JoinColumn(name = "bus_id", referencedColumnName = "busId")
//    private List<Seat> seat;
}
