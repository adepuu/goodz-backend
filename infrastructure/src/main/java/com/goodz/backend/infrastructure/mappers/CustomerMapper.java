package com.goodz.backend.infrastructure.mappers;


import com.goodz.backend.domain.context.element.customer.Customer;
import com.goodz.backend.infrastructure.db.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  Customer toCustomer(CustomerEntity entity);

  CustomerEntity toCustomerEntity(Customer customer);
}