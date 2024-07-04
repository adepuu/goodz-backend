package com.goodz.backend.infrastructure.mappers;

import com.goodz.backend.domain.context.element.order.Order;
import com.goodz.backend.domain.context.element.order.lineitem.LineItem;
import com.goodz.backend.infrastructure.db.entities.LineItemEntity;
import com.goodz.backend.infrastructure.db.entities.OrderEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T07:29:24+0700",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private LineItemMapper lineItemMapper;

    @Override
    public Order toOrder(OrderEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Order.OrderBuilder<?, ?> order = Order.builder();

        order.id( entity.getId() );
        order.status( entity.getStatus() );
        order.lineItems( lineItemEntityListToLineItemList( entity.getLineItems() ) );
        order.payment( entity.getPayment() );

        return order.build();
    }

    @Override
    public OrderEntity toOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity.OrderEntityBuilder orderEntity = OrderEntity.builder();

        orderEntity.id( order.getId() );
        orderEntity.status( order.getStatus() );
        orderEntity.lineItems( lineItemListToLineItemEntityList( order.getLineItems() ) );
        orderEntity.payment( order.getPayment() );

        return orderEntity.build();
    }

    protected List<LineItem> lineItemEntityListToLineItemList(List<LineItemEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<LineItem> list1 = new ArrayList<LineItem>( list.size() );
        for ( LineItemEntity lineItemEntity : list ) {
            list1.add( lineItemMapper.toLineItem( lineItemEntity ) );
        }

        return list1;
    }

    protected List<LineItemEntity> lineItemListToLineItemEntityList(List<LineItem> list) {
        if ( list == null ) {
            return null;
        }

        List<LineItemEntity> list1 = new ArrayList<LineItemEntity>( list.size() );
        for ( LineItem lineItem : list ) {
            list1.add( lineItemMapper.toLineItemEntity( lineItem ) );
        }

        return list1;
    }
}
