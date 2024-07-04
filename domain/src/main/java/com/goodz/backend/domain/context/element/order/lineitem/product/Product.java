package com.goodz.backend.domain.context.element.order.lineitem.product;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
  private Long id;
  private String name;
  private String company;
  private Integer quantity;
  private BigDecimal price;
}
