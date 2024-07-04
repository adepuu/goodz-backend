package com.goodz.backend.infrastructure.error;

import com.goodz.backend.domain.error.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends DomainException {
  public NotFoundException(String message) {
    super(message);
  }
}
