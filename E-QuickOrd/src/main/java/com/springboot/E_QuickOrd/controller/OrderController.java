package com.springboot.E_QuickOrd.controller;

import com.springboot.E_QuickOrd.entity.Order;
import com.springboot.E_QuickOrd.entity.User;
import com.springboot.E_QuickOrd.payload.OrderRequest;
import com.springboot.E_QuickOrd.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestBody OrderRequest request,
            @AuthenticationPrincipal User user) {

        Order createdOrder = orderService.createOrder(user, request.getItems());
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getUserOrders(
            @AuthenticationPrincipal User user) {

        List<Order> orders = orderService.getUserOrders(user);
        return ResponseEntity.ok(orders);
    }
}