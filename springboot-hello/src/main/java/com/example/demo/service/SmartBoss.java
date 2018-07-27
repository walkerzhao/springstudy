package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by andy on 2018/7/18.
 */
@Component
public class SmartBoss {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void goSomewhere() {
        bookService.bookFlight();
    }
}