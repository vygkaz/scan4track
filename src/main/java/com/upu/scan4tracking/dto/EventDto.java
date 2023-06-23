package com.upu.scan4tracking.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {
    private int id;
    private ItemPackageDto itemPackage;
    private EventTypeDto eventType;
    private String geolocation;
    private AddressDto address;
    private LocalDateTime timestamp;
}
