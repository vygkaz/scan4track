package com.upu.scan4tracking.dto;

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
public class ItemPackageDto {
	private int id;
	private String transportUnitId;
	private AddressDto deliveryAddress;
	private AddressDto returnAddress;
	private float weight;
	private LocalDateTime deliveryNotBefore;
	private LocalDateTime deliveryNotAfter;
	private EventDto lastEvent;
	private List<EventDto> events;
	private List<OrderItemDto> orderItems;
	private OrderDto order;
}