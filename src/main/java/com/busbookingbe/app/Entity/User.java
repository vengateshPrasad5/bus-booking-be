package com.busbookingbe.app.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username")
    private String userName;
    @Column(name="email_id")
    private String emailId;
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Booking> bookingList;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Passenger> passengerList;
}
