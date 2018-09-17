package com.rabbit.mq.RabbitSender.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MultiInputSource {
  String SUBSCRIBER = "create-book";

  @Input(SUBSCRIBER)
  SubscribableChannel subscriber();
}
