package com.goodz.backend.domain.context.element.common.address;

import com.goodz.backend.domain.context.element.ValueObject;
import com.goodz.backend.domain.context.element.common.Country;
import com.goodz.backend.domain.context.element.shipping.Customer;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Address implements ValueObject {
  String flatNumber;
  @NonNull
  Street street;

  PostalCode postalCode;

  @NonNull
  String city;

  @NonNull
  Country country;

  Customer customer;

  String additionalInformation;
}
