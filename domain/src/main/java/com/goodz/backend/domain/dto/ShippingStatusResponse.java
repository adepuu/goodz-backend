package com.goodz.backend.domain.dto;


import com.goodz.backend.domain.context.element.common.address.Address;
import com.goodz.backend.domain.context.element.shipping.ShippingStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingStatusResponse {
  private Long order;
  private Address address;
  private ShippingStatus status;
}
