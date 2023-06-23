package com.upu.scan4tracking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

	private int id;
	private Order order;
	private String productCode;
	private String productDesc;
	private int quantity;
	private ItemPackage itemPackage;
}
