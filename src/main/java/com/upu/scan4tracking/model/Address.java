package com.upu.scan4tracking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private int id;
    private String company;
    private String contact;
    private String addressLine1;
    private String addressLine2;
    private String suburb;
    private String city;
    private String countryCode;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private String geocode;
}
