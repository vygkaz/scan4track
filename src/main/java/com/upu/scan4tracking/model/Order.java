package com.upu.scan4tracking.model;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seller", nullable = false)
    private String seller;

    @Column(name = "buyer", nullable = false)
    private String buyer;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "order_number", nullable = false)
    private String orderNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address deliveryAddress;

    @Column(name = "do_not_deliver_before")
    private LocalDateTime doNotDeliverBefore;

    @Column(name = "do_not_deliver_after")
    private LocalDateTime doNotDeliverAfter;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
