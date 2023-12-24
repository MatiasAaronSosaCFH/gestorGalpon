package com.GestorGalpon.repository;

import com.GestorGalpon.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
