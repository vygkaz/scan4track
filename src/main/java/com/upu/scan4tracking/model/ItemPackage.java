package com.upu.scan4tracking.model;

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
@Table(name = "item_package")
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

	private LocalDateTime deliveryNotBefore;  // N

	private LocalDateTime deliveryNotAfter;

	@OneToOne(cascade = CascadeType.ALL)
	private Event lastEvent;

	@OneToMany(mappedBy = "itemPackage", cascade = CascadeType.ALL)
	private List<Event> events;

	@ManyToOne(cascade = CascadeType.ALL)
	private Order order;
}