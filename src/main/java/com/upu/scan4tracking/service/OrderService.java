package com.upu.scan4tracking.service;

import java.time.Clock;
import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
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
		orderEntity.setDate(LocalDateTime.now(Clock.systemUTC()));
		final Order save = repository.save(orderEntity);
		return mapper.map(save, OrderDto.class);
	}

	public OrderDto getOrder(String orderNumber) {
		final Order order = repository.findAllByOrderNumber(orderNumber);
		return mapper.map(order, OrderDto.class);
	}
}
