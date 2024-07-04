package com.goodz.backend.domain.context;

import com.goodz.backend.domain.context.element.AggregateRoot;
import com.goodz.backend.domain.context.element.customer.Customer;
import com.goodz.backend.domain.context.element.order.Order;
import com.goodz.backend.domain.context.element.order.lineitem.product.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class CustomerOrder extends AggregateRoot<UUID> {

  private Customer customer;

  private Order order;
  private List<Product> products;
}
