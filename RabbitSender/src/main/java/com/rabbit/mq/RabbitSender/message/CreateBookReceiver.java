package com.rabbit.mq.RabbitSender.message;

import com.rabbit.mq.RabbitSender.config.MultiInputSource;
import com.rabbit.mq.RabbitSender.model.Book;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class CreateBookReceiver {

  @StreamListener(target = MultiInputSource.SUBSCRIBER)
  public void onReschedule(Book book) {
    System.out.print("Message arrived \n" + book.toString());
  }
}
