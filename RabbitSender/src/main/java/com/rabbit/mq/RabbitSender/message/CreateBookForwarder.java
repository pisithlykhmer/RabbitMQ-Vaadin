package com.rabbit.mq.RabbitSender.message;

import com.rabbit.mq.RabbitSender.config.MultiOutputSource;
import com.rabbit.mq.RabbitSender.model.Book;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MultiOutputSource.class)
public class CreateBookForwarder {
  private final MultiOutputSource messagingChannel;

  public CreateBookForwarder(MultiOutputSource messagingChannel) {
    this.messagingChannel = messagingChannel;
  }

  public void messageSending (Book book) {
    messagingChannel.outputCreateBook().send(MessageBuilder.withPayload(book).build());
  }
}
