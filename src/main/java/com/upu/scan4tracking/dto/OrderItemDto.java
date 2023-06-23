package com.upu.scan4tracking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDto {

	private int id;
	private OrderDto order;
	private String productCode;
	private String productDesc;
	private int quantity;
	private ItemPackageDto itemPackage;
}
