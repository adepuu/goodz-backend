package com.goodz.backend.infrastructure.services;

import com.goodz.backend.infrastructure.db.entities.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
  @Override
  public CustomerEntity getCustomerById(UUID userId) {
    return null;
  }
}
