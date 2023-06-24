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
import com.upu.scan4tracking.model.Address;
import com.upu.scan4tracking.model.Event;
import com.upu.scan4tracking.model.EventType;
import com.upu.scan4tracking.model.ItemPackage;
import com.upu.scan4tracking.model.Order;

@Service
@RequiredArgsConstructor
public class OrderService {

	private static final String LOCATION = "Weltpoststrasse 4, 3015 Bern, Switzerland";
	private final Mapper mapper;

	private final List<ItemPackage> packages = new ArrayList<>();

	public ItemPackage save(OrderDto order) {
		final Order orderEntity = mapper.map(order, Order.class);
		//		final OrderItem save1 = orderItemRepository.save(orderEntity.getOrderItems().get(0));
		orderEntity.setOrderNumber(String.valueOf(packages.size()));
		//		orderEntity.setOrderItems(orderItems);
		orderEntity.setDate(LocalDateTime.now(Clock.systemUTC()));
		ItemPackage itemPackage = ItemPackage.builder()
				.transportUnitId(order.getSscc())
				.lastEvent(Event.builder()
						.eventType(DESPATCHED)
						.timestamp(LocalDateTime.now(Clock.systemUTC()))
						.build())
				.weight(1L)
				.deliveryNotAfter(order.getDoNotDeliverAfter())
				.order(orderEntity)
				.deliveryAddress(orderEntity.getDeliveryAddress())
				.returnAddress(Address.builder()
						.city("Bern")
						.postalCode("3015")
						.countryCode("Switzerland")
						.addressLine1("Weltpoststrasse 4")
						.build())
				.events(List.of(Event.builder()
						.timestamp(LocalDateTime.now(Clock.systemUTC()))
						.eventType(EventType.REGISTERED)
						.geolocation(LOCATION)
						.build()))
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

	public ItemPackageDto addEvent(String barcode, EventType eventType, String location) {
		return packages.stream()
				.filter(p -> Objects.equals(p.getTransportUnitId(), barcode))
				.findFirst()
				.map(p -> {
					final List<Event> events = new ArrayList<>(p.getEvents());
					events.add(Event.builder()
							.timestamp(LocalDateTime.now(Clock.systemUTC()))
							.eventType(eventType)
									.geolocation(location)
							.build());
					p.setEvents(events);
					return mapper.map(p, ItemPackageDto.class);
				})
				.orElse(null);
	}

}
