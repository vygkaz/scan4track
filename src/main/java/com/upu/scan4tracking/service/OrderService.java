package com.upu.scan4tracking.service;

import org.springframework.stereotype.Service;

import com.upu.scan4tracking.model.Order;

@Service
public class OrderService {

	public Order getOrder(String orderNumber) {
		return Order.builder()
				.orderNumber(orderNumber)
				.build();
	}
}
