package com.goodz.backend.infrastructure.services;

import com.goodz.backend.infrastructure.db.entities.CustomerEntity;

import java.util.UUID;

public interface CustomerService {
  CustomerEntity getCustomerById(UUID userId);
}
