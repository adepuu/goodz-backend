package com.goodz.backend.infrastructure.services;

import com.goodz.backend.domain.dto.*;
import com.goodz.backend.infrastructure.db.entities.OrderEntity;
import com.goodz.backend.infrastructure.error.NotFoundException;

public interface OrderService {
  OrderEntity getById(String id);

  SingleOrderResponse processOrder(SubmitOrderRequest submitOrderRequest) throws NotFoundException;

  OrderEntity updateOrder(String id, UpdateOrderRequest updateOrderRequest);

  OrdersResponse getAll(Integer page, Integer size, String sortBy, String direction);

  GenericResponse<Void> deleteById(String id, String token);
}
