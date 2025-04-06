package com.springboot.E_QuickOrd.service;

import com.springboot.E_QuickOrd.entity.Order;
import com.springboot.E_QuickOrd.entity.OrderItem;
import com.springboot.E_QuickOrd.entity.Product;
import com.springboot.E_QuickOrd.entity.User;
import com.springboot.E_QuickOrd.repository.OrderRepository;
import com.springboot.E_QuickOrd.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

        private final OrderRepository orderRepository;
        private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order createnewOrder(User user, List<OrderItemDTO> orderItems ) {
        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());

        for (OrderItemDTO itemDTO : items) {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemDTO.getQuantity());

            order.getOrderItems().add(item);
        }

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUser(user);
    }
}
