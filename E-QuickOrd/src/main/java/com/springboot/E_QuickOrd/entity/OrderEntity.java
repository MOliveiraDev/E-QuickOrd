package com.springboot.E_QuickOrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class OrderEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "cliente_id", nullable = false)
        private CustomerEntity customer;

        @Column(nullable = false)
        private LocalDateTime orderDate;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private OrderStatus status;

        @ManyToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)

}

