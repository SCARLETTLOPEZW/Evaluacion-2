package com.smartlogix.order.controller;

import com.smartlogix.order.domain.Order;
import com.smartlogix.order.domain.OrderStatus;
import com.smartlogix.order.dto.CreateOrderRequest;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();

    @GetMapping
    public List<Order> getOrders() {
        return orders;
    }

    @GetMapping("/{orderNumber}")
    public Order getOrder(@PathVariable String orderNumber) {

        return orders.stream()
                .filter(o -> orderNumber.equals(o.getOrderNumber()))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest request) {

        Order order = new Order(
                "ORD-" + (orders.size() + 1),
                request.getCustomerName(),
                request.getCustomerEmail(),
                request.getShippingAddress(),
                OrderStatus.CREATED,
                request.getTotal(),
                LocalDateTime.now()
        );

        orders.add(order);

        return order;
    }
}