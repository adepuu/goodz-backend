package com.goodz.backend.infrastructure.db.repository;


import com.goodz.backend.infrastructure.db.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}

