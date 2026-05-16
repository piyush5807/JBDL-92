package com.example.library_system.controllers;

import com.example.library_system.dtos.BookResponse;
import com.example.library_system.dtos.CreateBookRequest;
import com.example.library_system.models.Book;
import com.example.library_system.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public Integer createBook(@Valid @RequestBody CreateBookRequest createBookRequest){
        return this.bookService.createBook(createBookRequest);
    }

    @GetMapping("/books/{bookId}")
    public BookResponse getBookDetails(@PathVariable("bookId") Integer bookId){
        return this.bookService.getBookDetails(bookId);
    }

}
