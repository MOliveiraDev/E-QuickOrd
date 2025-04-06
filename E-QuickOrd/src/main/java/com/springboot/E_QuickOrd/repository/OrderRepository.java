package com.springboot.E_QuickOrd.repository;

import com.springboot.E_QuickOrd.entity.Order;
import com.springboot.E_QuickOrd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository <Order, Long> {
    List <Order> findByUser(User user);
}
