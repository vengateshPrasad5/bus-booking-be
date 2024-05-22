package com.busbookingbe.app.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="seat_id")
    private Long seatId;
    @Column(name = "seat_no")
    private String seatNo;
    private int height;
    @Column(name = "bus_row")
    private int busRow;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    @JsonBackReference
    private Bus bus;

//    @ManyToOne
//    private Booking booking;

}
