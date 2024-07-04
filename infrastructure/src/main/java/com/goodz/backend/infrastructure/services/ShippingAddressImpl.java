package com.goodz.backend.infrastructure.services;


import com.goodz.backend.domain.context.ShippingProcess;
import com.goodz.backend.domain.context.element.shipping.ShippingStatus;
import com.goodz.backend.domain.dto.ShippingStatusResponse;
import com.goodz.backend.domain.event.CustomSpringEvent;
import com.goodz.backend.domain.event.EventBus;
import com.goodz.backend.domain.event.EventSubscriber;
import com.goodz.backend.domain.event.EventType;
import com.goodz.backend.domain.service.ShippingProcessAdapter;
import com.goodz.backend.infrastructure.db.entities.AddressEntity;
import com.goodz.backend.infrastructure.db.entities.OrderEntity;
import com.goodz.backend.infrastructure.db.entities.ShippingEntity;
import com.goodz.backend.infrastructure.db.repository.AddressRepository;
import com.goodz.backend.infrastructure.db.repository.ShippingRepository;
import com.goodz.backend.infrastructure.error.NotFoundException;
import com.goodz.backend.infrastructure.mappers.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class ShippingAddressImpl implements ShippingService, EventSubscriber {

  private final AddressRepository addressRepository;
  private final ShippingRepository shippingRepository;
  private final ShippingProcessAdapter shippingProcessAdapter;
  private final AddressMapper addressMapper;

  @Autowired
  public ShippingAddressImpl(AddressRepository addressRepository,
                             ShippingRepository shippingRepository,
                             ShippingProcessAdapter shippingProcessAdapter,
                             AddressMapper addressMapper,
                             EventBus eventBus) {
    this.addressRepository = addressRepository;
    this.shippingRepository = shippingRepository;
    this.shippingProcessAdapter = shippingProcessAdapter;
    this.addressMapper = addressMapper;
    eventBus.subscribe(EventType.SHIPPING_INITIALIZE, this);
  }

  @Override
  public void onEvent(CustomSpringEvent event) throws NotFoundException {
    log.info("Received an event: {}", event);
    if (event.getEventType().equals(EventType.SHIPPING_INITIALIZE)) {

      //Validate address
      Long address = (Long) event.getSource();
      AddressEntity addressEntity = addressRepository.findById(address)
              .orElseThrow(() -> new NotFoundException("No address was found by the given id"));

      // send the address to its processor for now
      ShippingProcess shippingProcess = ShippingProcess.builder()
              .id(UUID.randomUUID())
              .address(addressMapper.toAddress(addressEntity))
              .order((Long) event.getData())
              .build();

      ShippingStatusResponse shippingStatusResponse = shippingProcessAdapter.processAddress(shippingProcess);
      if (shippingStatusResponse.getStatus().equals(ShippingStatus.APPROVED)) {
        log.info("Shipping request was approved!");
        shippingRepository.save(ShippingEntity.builder()
                .address(new AddressEntity(address))
                .order(new OrderEntity((Long) event.getData()))
                .build());
      }

    }
  }
}
