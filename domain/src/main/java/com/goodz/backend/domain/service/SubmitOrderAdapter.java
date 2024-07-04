package com.goodz.backend.domain.service;

import com.goodz.backend.domain.context.CustomerOrder;
import com.goodz.backend.domain.dto.SingleOrderResponse;

public interface SubmitOrderAdapter {
  SingleOrderResponse validateOrder(CustomerOrder customerOrder);
}
