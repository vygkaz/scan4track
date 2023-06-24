package com.upu.scan4tracking.service;

import static com.upu.scan4tracking.model.EventType.DESPATCHED;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.upu.scan4tracking.dto.ItemPackageDto;
import com.upu.scan4tracking.dto.OrderDto;
import com.upu.scan4tracking.model.Event;
import com.upu.scan4tracking.model.ItemPackage;
import com.upu.scan4tracking.model.Order;
import com.upu.scan4tracking.model.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository repository;
	private final Mapper mapper;

	private final List<ItemPackage> packages = new ArrayList<>();

	public ItemPackage save(OrderDto order) {
		final Order orderEntity = mapper.map(order, Order.class);
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
				.order(orderEntity)
				.deliveryAddress(orderEntity.getDeliveryAddress())
				.build();
		packages.add(itemPackage);
		//		final Orders save = repository.save(orderEntity);
		return mapper.map(itemPackage, ItemPackage.class);
	}

	public ItemPackageDto getShipment(String barcode) {
		final ItemPackage order = packages.stream()
				.filter(p -> Objects.equals(p.getTransportUnitId(), barcode))
				.findFirst()
				.orElse(null);
		return mapper.map(order, ItemPackageDto.class);
	}

//	public OrderDto getOrder(String orderNumber) {
//		final Orders order = packages.stream()
//				.filter(p -> p.getOrders() != null && Objects.equals(p.getOrders().getOrderNumber(), orderNumber))
//				.findFirst()
//				.orElse(null);
//		return mapper.map(order, OrderDto.class);
//	}
}
