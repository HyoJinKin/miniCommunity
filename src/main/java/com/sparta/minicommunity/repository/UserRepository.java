package com.sparta.minicommunity.repository;

import com.sparta.minicommunity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

}
