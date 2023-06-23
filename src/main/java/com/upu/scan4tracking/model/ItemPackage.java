package com.upu.scan4tracking.model;

// Constructors, getters, and setters

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "packages")
public class ItemPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String transportUnitId;

	@ManyToOne
	private Address deliveryAddress;

	@ManyToOne
	private Address returnAddress;

	private float weight;

	private LocalDateTime deliveryNotBefore;

	private LocalDateTime deliveryNotAfter;

	@OneToOne
	private Event lastEvent;

	@OneToOne
	private Order order;
}