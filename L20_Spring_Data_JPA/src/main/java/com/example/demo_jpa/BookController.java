package com.example.demo_jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/v1/books")
    public Integer createBook(@RequestBody CreateBookRequest createBookRequest){
        return bookService.createBook(createBookRequest);
    }
}
