package com.goodz.backend.infrastructure.mappers;

import com.goodz.backend.domain.context.element.order.lineitem.product.Product;
import com.goodz.backend.infrastructure.db.entities.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T07:29:25+0700",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( entity.getId() );
        product.name( entity.getName() );
        product.company( entity.getCompany() );
        product.quantity( entity.getQuantity() );
        product.price( entity.getPrice() );

        return product.build();
    }

    @Override
    public ProductEntity toProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.id( product.getId() );
        productEntity.name( product.getName() );
        productEntity.company( product.getCompany() );
        productEntity.quantity( product.getQuantity() );
        productEntity.price( product.getPrice() );

        return productEntity.build();
    }
}
