package com.example.demo_jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/v1/books")
    public Integer createBook(@RequestBody CreateBookRequest createBookRequest){
        return bookService.createBook(createBookRequest);
    }

    @GetMapping("/v1/books-all")
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/v1/book-by-id/{id}")
    public Book getAllBooks(@PathVariable("id") Integer bookId){
        return this.bookService.getBookById(bookId);
    }

    @GetMapping("/v1/books")
    public List<Book> getBooks(@RequestParam("genre") Genre genre,
                               @RequestParam("author") String author,
                               @RequestParam(value = "isJPQL", defaultValue = "false", required = false) boolean isJPQL){

        if(isJPQL){
            return this.bookService.getAllBookByGenre2(genre, author);
        }

        return this.bookService.getAllBookByGenre(genre, author);
    }

    @GetMapping("/v1/books/bulkiest")
    public Book getBulkiestBook(@RequestParam("genre") Genre genre,
                                @RequestParam("author") String author){
        return this.bookService.getBulkiestBookOfGenre(genre, author);
    }

    // Find all the books of a particular genre
    // Take genre as a query param from client and use it in the sql query to get the relevant data.


}
