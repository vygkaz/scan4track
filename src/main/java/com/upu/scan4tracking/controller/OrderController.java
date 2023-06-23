package com.upu.scan4tracking.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.upu.scan4tracking.dto.OrderDto;
import com.upu.scan4tracking.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@GetMapping("/order/{orderNumber}")
	public String getPackage(Model model, @PathVariable String orderNumber) {
		final OrderDto order = orderService.getOrder(orderNumber);

		model.addAttribute("order", order);

		return "order";
	}

	@PostMapping("/order/")
	public OrderDto getPackage(@RequestBody OrderDto order) {
		return orderService.save(order);
	}
}