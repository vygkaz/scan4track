package com.upu.scan4tracking.dto;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private int id;
    private String seller;
    private String buyer;
    @JsonFormat(shape = STRING, pattern = "dd-MM-yy HH:mm:ss")
    private LocalDateTime date;
    private String orderNumber;
    private AddressDto deliveryAddress;
//    private LocalDateTime doNotDeliverBefore;
//    private LocalDateTime doNotDeliverAfter;
    private List<OrderItemDto> orderItems;
    private List<ItemPackageDto> packages;
}
