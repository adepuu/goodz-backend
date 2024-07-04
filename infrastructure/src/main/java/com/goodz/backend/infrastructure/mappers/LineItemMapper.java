package com.goodz.backend.infrastructure.mappers;


import com.goodz.backend.domain.context.element.order.lineitem.LineItem;
import com.goodz.backend.infrastructure.db.entities.LineItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineItemMapper {
  @Mapping(source = "product.id", target = "product")
  @Mapping(source = "customerOrder.id", target = "order")
  LineItem toLineItem(LineItemEntity entity);

  @Mapping(source = "product", target = "product.id")
  @Mapping(source = "order", target = "customerOrder.id")
  LineItemEntity toLineItemEntity(LineItem lineItem);

}
