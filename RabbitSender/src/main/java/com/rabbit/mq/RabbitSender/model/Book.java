package com.rabbit.mq.RabbitSender.model;

import lombok.Data;

@Data
public class Book {
  String id;
  String title;
  String author;

  @Override
  public String toString() {
    return "This book has an id is: " + id +
      "\n" + "and the title of this book is: " + title +
      "\n" + "and this was wrote by: " + author + "\n";
  }
}
