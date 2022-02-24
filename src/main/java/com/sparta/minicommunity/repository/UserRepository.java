package com.sparta.minicommunity.repository;

import com.sparta.minicommunity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
