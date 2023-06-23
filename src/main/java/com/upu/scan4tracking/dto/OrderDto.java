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
    private LocalDateTime date;
    private String orderNumber;
    private AddressDto deliveryAddress;
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime doNotDeliverBefore;
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd'T'HH:mm")

    private LocalDateTime doNotDeliverAfter;
    private List<OrderItemDto> orderItems;
}
