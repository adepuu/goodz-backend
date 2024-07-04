package com.goodz.backend.infrastructure.mappers;


import com.goodz.backend.domain.context.element.order.Order;
import com.goodz.backend.infrastructure.db.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LineItemMapper.class)
public interface OrderMapper {
  Order toOrder(OrderEntity entity);

  OrderEntity toOrderEntity(Order order);
}
