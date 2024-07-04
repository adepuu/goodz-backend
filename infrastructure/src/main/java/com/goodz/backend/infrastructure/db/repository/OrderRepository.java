package com.goodz.backend.infrastructure.db.repository;


import com.goodz.backend.infrastructure.db.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
