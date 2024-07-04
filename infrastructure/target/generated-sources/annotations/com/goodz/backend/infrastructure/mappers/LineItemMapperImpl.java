package com.goodz.backend.infrastructure.mappers;

import com.goodz.backend.domain.context.element.order.lineitem.LineItem;
import com.goodz.backend.infrastructure.db.entities.LineItemEntity;
import com.goodz.backend.infrastructure.db.entities.OrderEntity;
import com.goodz.backend.infrastructure.db.entities.ProductEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T07:29:25+0700",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class LineItemMapperImpl implements LineItemMapper {

    @Override
    public LineItem toLineItem(LineItemEntity entity) {
        if ( entity == null ) {
            return null;
        }

        LineItem.LineItemBuilder lineItem = LineItem.builder();

        lineItem.product( entityProductId( entity ) );
        lineItem.order( entityCustomerOrderId( entity ) );
        lineItem.id( entity.getId() );
        lineItem.quantity( entity.getQuantity() );

        return lineItem.build();
    }

    @Override
    public LineItemEntity toLineItemEntity(LineItem lineItem) {
        if ( lineItem == null ) {
            return null;
        }

        LineItemEntity.LineItemEntityBuilder lineItemEntity = LineItemEntity.builder();

        lineItemEntity.product( lineItemToProductEntity( lineItem ) );
        lineItemEntity.customerOrder( lineItemToOrderEntity( lineItem ) );
        lineItemEntity.id( lineItem.getId() );
        lineItemEntity.quantity( lineItem.getQuantity() );

        return lineItemEntity.build();
    }

    private Long entityProductId(LineItemEntity lineItemEntity) {
        if ( lineItemEntity == null ) {
            return null;
        }
        ProductEntity product = lineItemEntity.getProduct();
        if ( product == null ) {
            return null;
        }
        Long id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long entityCustomerOrderId(LineItemEntity lineItemEntity) {
        if ( lineItemEntity == null ) {
            return null;
        }
        OrderEntity customerOrder = lineItemEntity.getCustomerOrder();
        if ( customerOrder == null ) {
            return null;
        }
        Long id = customerOrder.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected ProductEntity lineItemToProductEntity(LineItem lineItem) {
        if ( lineItem == null ) {
            return null;
        }

        ProductEntity.ProductEntityBuilder productEntity = ProductEntity.builder();

        productEntity.id( lineItem.getProduct() );

        return productEntity.build();
    }

    protected OrderEntity lineItemToOrderEntity(LineItem lineItem) {
        if ( lineItem == null ) {
            return null;
        }

        OrderEntity.OrderEntityBuilder orderEntity = OrderEntity.builder();

        orderEntity.id( lineItem.getOrder() );

        return orderEntity.build();
    }
}
