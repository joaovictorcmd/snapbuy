package com.joaovictorcmd.snapbuy.snapbuy.entities;

import com.joaovictorcmd.snapbuy.snapbuy.entities.enums.OrderStatus;

import java.time.Instant;

/**
 * @author joaovictorcmd
 * @date 2024 Oct 23
 */
public class Order {
    private Long id;
    private Instant moment;
    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status) {
        this.id = id;
        this.moment = moment;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
