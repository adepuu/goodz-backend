package com.goodz.backend.infrastructure.mappers;

import com.goodz.backend.domain.context.element.customer.Customer;
import com.goodz.backend.infrastructure.db.entities.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T07:29:25+0700",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Customer.CustomerBuilder<?, ?> customer = Customer.builder();

        customer.id( entity.getId() );
        customer.displayName( entity.getDisplayName() );
        customer.firstName( entity.getFirstName() );
        customer.lastName( entity.getLastName() );
        customer.state( entity.getState() );
        customer.type( entity.getType() );

        return customer.build();
    }

    @Override
    public CustomerEntity toCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        customerEntity.id( customer.getId() );
        customerEntity.displayName( customer.getDisplayName() );
        customerEntity.firstName( customer.getFirstName() );
        customerEntity.lastName( customer.getLastName() );
        customerEntity.state( customer.getState() );
        customerEntity.type( customer.getType() );

        return customerEntity.build();
    }
}
