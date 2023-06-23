package com.upu.scan4tracking.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.upu.scan4tracking.service.OrderService;

@Controller
@RequiredArgsConstructor
public class OrderFormController {

    private final OrderService orderService;

    @GetMapping()
    public String getOrderForm() {
        return "order";
    }
}