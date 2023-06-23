package com.upu.scan4tracking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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