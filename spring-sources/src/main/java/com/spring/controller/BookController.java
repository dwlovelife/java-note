package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @RequestMapping(value = "/get")
    @ResponseBody
    public String getBook() {
        System.out.println("book");
        return "hello";
    }

}
