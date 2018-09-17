package com.rabbit.mq.RabbitSender.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.inject.Inject;

@Configuration
@EnableBinding(value = {MultiInputSource.class, Source.class})
public class RabbitConfig {

  @Bean
  @Inject
  public TopicExchange contractCreateTopic(
    @Value("${spring.cloud.stream.bindings.output-create-book.destination}") String exchangeName) {
    return new TopicExchange(exchangeName, true, false);
  }
}
