package com.upu.scan4tracking.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.upu.scan4tracking.dto.ItemPackageDto;
import com.upu.scan4tracking.model.ItemPackage;
import com.upu.scan4tracking.service.ItemPackageService;
import com.upu.scan4tracking.service.OrderService;

@Controller
@RequiredArgsConstructor
public class ItemPackageController {

    private final ItemPackageService shipmentService;
    private final OrderService orderService;

    @GetMapping("/00/{barcode}")
    public String getPackage(Model model, @PathVariable String barcode) {
        final ItemPackageDto shipment = orderService.getShipment(barcode);

        model.addAttribute("itemPackage", shipment);

        return "package_info";
    }
}