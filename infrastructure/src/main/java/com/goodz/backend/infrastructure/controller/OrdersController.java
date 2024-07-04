package com.goodz.backend.infrastructure.controller;

import com.goodz.backend.domain.dto.GenericResponse;
import com.goodz.backend.domain.dto.SingleOrderResponse;
import com.goodz.backend.domain.dto.SubmitOrderRequest;
import com.goodz.backend.infrastructure.error.NotFoundException;
import com.goodz.backend.infrastructure.services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/v1/orders")
@RestController
public class OrdersController {
  private final OrderService orderService;

  @PostMapping("/submitOrder")
  public GenericResponse<SingleOrderResponse> placeOrder(@Valid @RequestBody SubmitOrderRequest createOrderRequest) throws NotFoundException {
    SingleOrderResponse orderResponse = orderService.processOrder(createOrderRequest);
    return GenericResponse.<SingleOrderResponse>builder()
            .code(201)
            .data(orderResponse)
            .message("Created!")
            .build();
  }
}
