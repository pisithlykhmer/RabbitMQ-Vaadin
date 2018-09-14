package com.rabbit.mq.RabbitSender.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CreatedBookChannel {
  String SUBSCRIBER = "create-book";

  @Input(SUBSCRIBER)
  SubscribableChannel subscriber();
}
