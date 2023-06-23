package com.upu.scan4tracking.service;

import org.springframework.stereotype.Service;

import com.upu.scan4tracking.model.ItemPackage;

@Service
public class ItemPackageService {

	public ItemPackage getShipment(String barcode) {
		return ItemPackage.builder()
				.transportUnitId(barcode)
				.build();
	}
}
