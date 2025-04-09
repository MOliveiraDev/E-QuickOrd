package com.springboot.E_QuickOrd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderItemEntity> items = new ArrayList<>();

        @Column(nullable = false)
        private BigDecimal totalPrice;

        public void addItem(OrderItemEntity item) {
                items.add(item);
                item.setOrder(this);
                calculateTotalPrice();

        }

        //calcular o preço total do pedido
        public void calculateTotalPrice() {
                totalPrice = items.stream()
                        .map(OrderItemEntity::getTotalPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
}

