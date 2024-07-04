package com.goodz.backend.domain.event;


public interface EventBus {
  void publish(CustomSpringEvent event);

  void subscribe(EventType eventType, EventSubscriber subscriber);

  void unsubscribe(EventType eventType, EventSubscriber subscriber);
}
