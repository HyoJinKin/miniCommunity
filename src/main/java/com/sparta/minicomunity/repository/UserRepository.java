package com.sparta.minicomunity.repository;

import com.sparta.minicomunity.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Register, Long> {
}
