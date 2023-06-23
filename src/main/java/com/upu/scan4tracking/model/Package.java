package com.upu.scan4tracking.model;

public class Package {
    private int id;
    private String transportUnitId;
    private int deliveryAddress;
    private int returnAddress;
    private float weight;
    private LocalDateTime deliveryNotBefore;
    private LocalDateTime deliveryNotAfter;
    private Event lastEvent;
    private OrderItem[] orderItems;
    // Constructors, getters, and setters
}