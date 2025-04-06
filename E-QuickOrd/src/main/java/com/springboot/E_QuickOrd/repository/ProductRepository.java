package com.springboot.E_QuickOrd.repository;

import com.springboot.E_QuickOrd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
