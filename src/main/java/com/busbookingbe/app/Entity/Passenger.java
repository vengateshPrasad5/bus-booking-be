package com.busbookingbe.app.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;
    private String name;
    private int age;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @JsonProperty("bus")
    @JsonIgnoreProperties("seats")
    public Bus getBus() {
        return booking != null ? booking.getBus() : null;
    }
}
