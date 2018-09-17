package com.rabbit.mq.RabbitSender.ui;

import com.rabbit.mq.RabbitSender.message.CreateBookForwarder;
import com.rabbit.mq.RabbitSender.model.Book;
import com.vaadin.annotations.Theme;
import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

@SpringUI
@Theme("book")
public class SenderUI extends UI {

  private TextField idTextField = new TextField("ID");
  private TextField titleTextField = new TextField("Title");
  private TextField authorTextField = new TextField("Author");
  private Button sendButton;
  private transient CreateBookForwarder createBookForwarder;
  private static final String EMPTY = "";
  private final transient Binder<Book> bookBinder = new BeanValidationBinder<>(Book.class);
  private static final String SEND_BUTTON_STYLE = "send-button borderless";

  public SenderUI(CreateBookForwarder createBookForwarder) {
    this.createBookForwarder = createBookForwarder;

    bookBinder.setBean(new Book());
    initComponent();
    initializeBinder(bookBinder);
  }

  @Override
  protected void init(VaadinRequest vaadinRequest) {
    setContent(createBookForm());
    addListener();
    setSizeFull();
  }

  private void initComponent () {
    idTextField = new TextField("ID");
    titleTextField = new TextField("Title");
    authorTextField = new TextField("Author");
    sendButton = createButton("Send message");
  }

  private void addListener() {
    sendButton.addClickListener(e-> {
      createBookForwarder.messageSending(bookBinder.getBean());
      bookBinder.setBean(new Book());
    });

    bookBinder.addStatusChangeListener(e-> sendButton.setEnabled(bookBinder.isValid()));
  }

  private Component createBookForm() {
    VerticalLayout bookForm = new VerticalLayout();
    bookForm.setSizeFull();

    GridLayout subLayout = new GridLayout(2,2);
    subLayout.setMargin(true);
    subLayout.setSpacing(true);
    subLayout.setStyleName("bg");

    subLayout.addComponent(idTextField);
    subLayout.addComponent(titleTextField);
    subLayout.addComponent(authorTextField);
    subLayout.addComponent(sendButton);

    subLayout.setComponentAlignment(idTextField, Alignment.MIDDLE_CENTER);
    subLayout.setComponentAlignment(titleTextField, Alignment.MIDDLE_CENTER);
    subLayout.setComponentAlignment(authorTextField, Alignment.MIDDLE_CENTER);
    subLayout.setComponentAlignment(sendButton, Alignment.MIDDLE_CENTER);

    bookForm.addComponent(subLayout);
    bookForm.setComponentAlignment(subLayout, Alignment.MIDDLE_CENTER);
    return bookForm;
  }

  private void initializeBinder(Binder<Book> bookBinder) {
    bookBinder.forField(idTextField).asRequired().withNullRepresentation(EMPTY).bind(Book::getId, Book::setId);
    bookBinder.forField(titleTextField).asRequired().withNullRepresentation(EMPTY).bind(Book::getTitle, Book::setTitle);
    bookBinder.forField(authorTextField).asRequired().withNullRepresentation(EMPTY).bind(Book::getAuthor, Book::setAuthor);
  }

  private Button createButton (String caption) {
    Button button = new Button(caption);
    button.setWidth(100, Unit.PERCENTAGE);
    button.setEnabled(false);
    button.setStyleName(SEND_BUTTON_STYLE);
    return button;
  }
}
