package com.goodz.backend.infrastructure.mappers;


import com.goodz.backend.domain.context.element.order.lineitem.product.Product;
import com.goodz.backend.infrastructure.db.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  Product toProduct(ProductEntity entity);

  ProductEntity toProductEntity(Product product);
}
