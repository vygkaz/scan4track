package com.upu.scan4tracking.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upu.scan4tracking.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findAllByOrderNumber(String orderNumber);
}
