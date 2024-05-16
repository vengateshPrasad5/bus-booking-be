package com.busbookingbe.app.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int seatNo;
    private int height;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

}
