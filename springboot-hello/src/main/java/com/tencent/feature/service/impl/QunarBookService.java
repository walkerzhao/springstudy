package com.tencent.feature.service.impl;

import com.tencent.feature.service.BookService;
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
