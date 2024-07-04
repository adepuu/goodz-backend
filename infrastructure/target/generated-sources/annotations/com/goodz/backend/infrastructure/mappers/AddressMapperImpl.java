package com.goodz.backend.infrastructure.mappers;

import com.goodz.backend.domain.context.element.common.Country;
import com.goodz.backend.domain.context.element.common.address.Address;
import com.goodz.backend.domain.context.element.common.address.PostalCode;
import com.goodz.backend.domain.context.element.common.address.Street;
import com.goodz.backend.domain.context.element.shipping.Customer;
import com.goodz.backend.infrastructure.db.entities.AddressEntity;
import com.goodz.backend.infrastructure.db.entities.CustomerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-04T07:29:25+0700",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(AddressEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.customer( customerEntityToCustomer( entity.getCustomer() ) );
        address.street( addressEntityToStreet( entity ) );
        address.postalCode( addressEntityToPostalCode( entity ) );
        address.country( addressEntityToCountry( entity ) );
        address.flatNumber( entity.getFlatNumber() );
        address.city( entity.getCity() );

        return address.build();
    }

    @Override
    public AddressEntity toAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity.AddressEntityBuilder addressEntity = AddressEntity.builder();

        addressEntity.customer( customerToCustomerEntity( address.getCustomer() ) );
        addressEntity.street( addressStreetName( address ) );
        addressEntity.postalCode( addressPostalCodeValue( address ) );
        addressEntity.country( addressCountryCode( address ) );
        addressEntity.flatNumber( address.getFlatNumber() );
        addressEntity.city( address.getCity() );

        return addressEntity.build();
    }

    protected Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = customerEntity.getId();
        name = customerEntity.getDisplayName();

        Customer customer = new Customer( id, name );

        return customer;
    }

    protected Street addressEntityToStreet(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        String name = null;

        name = addressEntity.getStreet();

        Street street = new Street( name );

        return street;
    }

    protected PostalCode addressEntityToPostalCode(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        String value = null;

        value = addressEntity.getPostalCode();

        PostalCode postalCode = new PostalCode( value );

        return postalCode;
    }

    protected Country addressEntityToCountry(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        String code = null;

        code = addressEntity.getCountry();

        Country country = new Country( code );

        return country;
    }

    protected CustomerEntity customerToCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity.CustomerEntityBuilder customerEntity = CustomerEntity.builder();

        customerEntity.id( customer.getId() );
        customerEntity.displayName( customer.getName() );

        return customerEntity.build();
    }

    private String addressStreetName(Address address) {
        if ( address == null ) {
            return null;
        }
        Street street = address.getStreet();
        if ( street == null ) {
            return null;
        }
        String name = street.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String addressPostalCodeValue(Address address) {
        if ( address == null ) {
            return null;
        }
        PostalCode postalCode = address.getPostalCode();
        if ( postalCode == null ) {
            return null;
        }
        String value = postalCode.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }

    private String addressCountryCode(Address address) {
        if ( address == null ) {
            return null;
        }
        Country country = address.getCountry();
        if ( country == null ) {
            return null;
        }
        String code = country.getCode();
        if ( code == null ) {
            return null;
        }
        return code;
    }
}
