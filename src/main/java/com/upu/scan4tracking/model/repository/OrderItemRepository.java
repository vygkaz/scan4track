package com.upu.scan4tracking.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upu.scan4tracking.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
