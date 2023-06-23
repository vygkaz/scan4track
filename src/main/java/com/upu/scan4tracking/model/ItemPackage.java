package com.upu.scan4tracking.model;

// Constructors, getters, and setters

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
public class ItemPackage {
	private int id;
	private String transportUnitId;
	private int deliveryAddress;
	private int returnAddress;
	private float weight;
	private LocalDateTime deliveryNotBefore;
	private LocalDateTime deliveryNotAfter;
	private Event lastEvent;
	private List<OrderItem> orderItems;
}