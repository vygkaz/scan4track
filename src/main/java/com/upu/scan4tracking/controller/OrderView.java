package com.upu.scan4tracking.controller;

import jakarta.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.upu.scan4tracking.dto.ItemPackageDto;
import com.upu.scan4tracking.dto.OrderDto;
import com.upu.scan4tracking.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderView {

	private final OrderService orderService;
	private HttpServletRequest request;

	@GetMapping("/")
	public String getNewOrderForm() {
		return "acme_simple";
	}

	@GetMapping("/order/{barcode}")
	public String getPackage(Model model, @PathVariable String barcode) {
		final ItemPackageDto shipment = orderService.getShipment(barcode);

		model.addAttribute("shipment", shipment);

		return "barcode";
	}
}