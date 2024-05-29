package com.busbookingbe.app.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "username",nullable = false,unique = true)
    private String userName;
    @Column(name="email_id",nullable = false,unique = true)
    private String emailId;
    @Column(nullable = false,unique = true)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Booking> bookingList;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Passenger> passengerList;
}
