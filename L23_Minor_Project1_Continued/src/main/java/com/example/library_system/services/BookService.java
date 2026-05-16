package com.example.library_system.services;

import com.example.library_system.dtos.BookResponse;
import com.example.library_system.dtos.CreateBookRequest;
import com.example.library_system.models.Author;
import com.example.library_system.models.Book;
import com.example.library_system.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    // In LLD, try to have SOLID principles in place --
    // S : Single responsible principle
    // Every class should be responsible to carry out operations that are meant only for it, not other class' responsibilities

    @Autowired
    AuthorService authorService;

    @Autowired
    BookRepository bookRepository;

    public Integer createBook(CreateBookRequest createBookRequest){

        Book book = createBookRequest.to();
        Author author = book.getAuthor();

        author = this.authorService.getOrCreateAuthor(author);

        book.setAuthor(author);

        this.bookRepository.save(book);
        return book.getId();
    }

    public BookResponse getBookDetails(Integer bookId) {
        Book book = this.bookRepository.findById(bookId).orElse(null);
        return book == null ? null : BookResponse.from(book);
    }

    /**
     * Approach 1:
     * 1. Create a book with empty author
     * 2. Create or get the author details (create if not exists or else get the existing record)
     * 3. Update the book
     */

    /**
     * Approach 2:
     * 1. Create or get the author details (create if not exists or else get the existing record)
     * 2. Create the book with the author details retrieved in step 1.
     */

    /**
     * Author is acting like a parent to the book table
     * While adding a book, either specify the correct parent or don't specify it at all.
     */
}
