package com.goodz.backend.domain.event;


public interface EventSubscriber {

  void onEvent(CustomSpringEvent event);
}
