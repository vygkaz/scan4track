package com.upu.scan4tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderView {

	@GetMapping("/")
	public String getNewOrderForm() {
		return "acme_simple";
	}
}