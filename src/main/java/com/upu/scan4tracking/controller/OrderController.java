package com.upu.scan4tracking.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upu.scan4tracking.dto.OrderDto;
import com.upu.scan4tracking.model.ItemPackage;
import com.upu.scan4tracking.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/order/")
	public ItemPackage getPackage(@RequestBody OrderDto order) {
		final ItemPackage itemPackage = orderService.save(order);
		//		model.addAttribute("order", savedOrder);
		//		String host = request.getServerName();
		//		int port = request.getServerPort();
		//		String uri = "http://" + host + "/" + port + "/00/" + savedOrder.getItemPackage().getTransportUnitId();
		//		model.addAttribute("uri", uri);
		return itemPackage;
	}
}