package com.springboot.E_QuickOrd.repository;

import com.springboot.E_QuickOrd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByEmail(String email);
}
