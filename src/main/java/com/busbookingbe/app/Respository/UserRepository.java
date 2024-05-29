package com.busbookingbe.app.Respository;

import com.busbookingbe.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailId(String username);

    Boolean existsByEmailId(String emailId);

    Optional<User> findByUserNameOrEmailId(String userName, String email);

    Boolean existsByUserName(String userName);
}
