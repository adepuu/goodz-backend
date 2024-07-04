package com.goodz.backend.domain.service;

import com.goodz.backend.domain.context.ShippingProcess;
import com.goodz.backend.domain.dto.ShippingStatusResponse;

public interface ShippingProcessAdapter {
  ShippingStatusResponse processAddress(ShippingProcess shippingProcess);
}
