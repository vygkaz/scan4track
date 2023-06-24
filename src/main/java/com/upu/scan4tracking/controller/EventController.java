package com.upu.scan4tracking.controller;

import static com.upu.scan4tracking.model.EventType.DELIVERED;
import static com.upu.scan4tracking.model.EventType.DESPATCHED;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upu.scan4tracking.dto.ItemPackageDto;
import com.upu.scan4tracking.service.OrderService;

@RestController
@RequiredArgsConstructor
public class EventController {

	private final OrderService orderService;

	@PostMapping("/event/despatch/{barcode}")
	public ItemPackageDto despatch(@PathVariable String barcode) {
		return orderService.addEvent(barcode, DESPATCHED, "Weltpoststrasse 4, 3015 Bern, Switzerland");
	}

	@PostMapping("/event/deliver/{barcode}")
	public ItemPackageDto deliver(@PathVariable String barcode) {
		return orderService.addEvent(barcode, DELIVERED, "Amsterdamseweg 206, 1182 HL Amstelveen, Netherlands");
	}
}