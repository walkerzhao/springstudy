package com.example.demo.service.impl;

import com.example.demo.service.BookService;
import org.springframework.stereotype.Component;

/**
 * Created by andy on 2018/7/18.
 */
@Component
public class QunarBookService implements BookService {
    public void bookFlight() {
        System.out.println("book fight by Qunar!");

    }
}
