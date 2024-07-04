package com.goodz.backend.domain.context.element.order.lineitem;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LineItem {

  private Long id;

  private Long order;

  private Long product;

  private Integer quantity;
}
