package com.busbookingbe.app.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;
    @Column(name = "reservation_date")
    private String reservationDate;
    private String status;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

//    @OneToMany
//    @JoinColumn(name = "seat_id")
//    private List<Seat> seats;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Passenger> passengerList;

}
