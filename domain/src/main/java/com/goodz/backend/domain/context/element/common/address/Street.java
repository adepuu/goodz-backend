package com.goodz.backend.domain.context.element.common.address;

import com.goodz.backend.domain.context.element.ValueObject;
import lombok.NonNull;
import lombok.Value;

@Value
public class Street implements ValueObject {
  @NonNull
  String name;
}
