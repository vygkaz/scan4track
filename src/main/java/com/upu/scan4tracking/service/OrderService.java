package com.upu.scan4tracking.service;

import lombok.RequiredArgsConstructor;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.upu.scan4tracking.dto.OrderDto;
import com.upu.scan4tracking.model.Order;
import com.upu.scan4tracking.model.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository repository;
	private final Mapper mapper;

	public OrderDto save(OrderDto order) {
		final Order orderEntity = mapper.map(order, Order.class);
		final Order save = repository.save(orderEntity);
		return mapper.map(orderEntity, OrderDto.class);
	}

	public OrderDto getOrder(String orderNumber) {
		final Order order = repository.findByOrderNumber(orderNumber);
		return mapper.map(order, OrderDto.class);
	}
}
