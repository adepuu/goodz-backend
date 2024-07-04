package com.goodz.backend.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrdersResponse {
  private List<SingleOrderResponse> blogs;
}
