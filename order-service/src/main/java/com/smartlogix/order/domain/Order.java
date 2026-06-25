package com.smartlogix.order.domain;

import java.time.LocalDateTime;

public class Order {

    private String orderNumber;
    private String customerName;
    private String customerEmail;
    private String shippingAddress;
    private OrderStatus status;
    private Double total;
    private LocalDateTime createdAt;

    // Constructor vacío
    public Order() {
    }

    // Constructor completo
    public Order(String orderNumber,
                 String customerName,
                 String customerEmail,
                 String shippingAddress,
                 OrderStatus status,
                 Double total,
                 LocalDateTime createdAt) {

        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.status = status;
        this.total = total;
        this.createdAt = createdAt;
    }

    // getters y setters...

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}