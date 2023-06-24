package com.upu.scan4tracking.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upu.scan4tracking.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	Orders findAllByOrderNumber(String orderNumber);
}
