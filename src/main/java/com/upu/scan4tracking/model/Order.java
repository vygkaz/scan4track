package com.upu.scan4tracking.model;

public class Order {
    private int id;
    private String seller;
    private String buyer;
    private LocalDateTime date;
    private String orderNumber;
    private Address deliveryAddress;
    private LocalDateTime doNotDeliverBefore;
    private LocalDateTime doNotDeliverAfter;
    private OrderItem[] orderItems;
    private Package[] packages;
    // Constructors, getters, and setters
}
