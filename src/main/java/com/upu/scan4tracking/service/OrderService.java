package com.upu.scan4tracking.service;

import static com.upu.scan4tracking.model.EventType.DESPATCHED;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.upu.scan4tracking.dto.OrderDto;
import com.upu.scan4tracking.model.Event;
import com.upu.scan4tracking.model.ItemPackage;
import com.upu.scan4tracking.model.Orders;
import com.upu.scan4tracking.model.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository repository;
	private final Mapper mapper;

	private final List<ItemPackage> packages = new ArrayList<>();

	public OrderDto save(OrderDto order) {
		final Orders orderEntity = mapper.map(order, Orders.class);
		//		final OrderItem save1 = orderItemRepository.save(orderEntity.getOrderItems().get(0));
		orderEntity.setOrderNumber(String.valueOf(packages.size()));
		//		orderEntity.setOrderItems(orderItems);
		orderEntity.setDate(LocalDateTime.now(Clock.systemUTC()));
		ItemPackage itemPackage = ItemPackage.builder()
				.transportUnitId("390999990000000018")
				.lastEvent(Event.builder()
						.eventType(DESPATCHED)
						.timestamp(LocalDateTime.now(Clock.systemUTC()))
						.build())
				.weight(1L)
				.deliveryNotAfter(order.getDoNotDeliverAfter())
				.orders(List.of(orderEntity))
				.build();
		orderEntity.setItemPackage(itemPackage);
		packages.add(itemPackage);
		//		final Orders save = repository.save(orderEntity);
		return mapper.map(orderEntity, OrderDto.class);
	}

	public OrderDto getOrder(String orderNumber) {
		final Orders order = packages.stream()
				.filter(p -> p.getOrders().stream().anyMatch(o -> Objects.equals(o.getOrderNumber(), orderNumber)))
				.findFirst()
				.map(p -> p.getOrders().get(0))
				.orElse(null);
		return mapper.map(order, OrderDto.class);
	}
}
