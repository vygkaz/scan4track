package com.upu.scan4tracking.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    private int id;
    private ItemPackage itemPackage;
    private EventType eventType;
    private String geolocation;
    private Address address;
    private LocalDateTime timestamp;
}
