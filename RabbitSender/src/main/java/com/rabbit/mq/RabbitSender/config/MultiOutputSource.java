package com.rabbit.mq.RabbitSender.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MultiOutputSource {
  String OUTPUT_CONTRACT_PENDING_UPLOAD = "output-create-book";

  @Output(OUTPUT_CONTRACT_PENDING_UPLOAD)
  MessageChannel outputCreateBook();
}
