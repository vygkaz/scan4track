package com.upu.scan4tracking.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int id;
    private String seller;
    private String buyer;
    private LocalDateTime date;
    private String orderNumber;
    private Address deliveryAddress;
    private LocalDateTime doNotDeliverBefore;
    private LocalDateTime doNotDeliverAfter;
    private List<OrderItem> orderItems;
    private List<ItemPackage> packages;
}
