package com.example.demo_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository; // SimpleJPARepository object

    public Integer createBook(CreateBookRequest createBookRequest){

        Book book = createBookRequest.to();
        book = bookRepository.save(book); // save function internally changes the input data as well in addition to returning the result from Spring boot 3.X onwards

        return book.getId();
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book getBookById(Integer bookId) {
        return this.bookRepository.getById(bookId);
    }

    public List<Book> getAllBookByGenre(Genre genre, String authorName){
        long start = System.currentTimeMillis();
        List<Book> result = this.bookRepository.getAllBooksByGenre(genre, authorName);

        long end = System.currentTimeMillis();
        System.out.println("Time to execute native query - " + (end-start));

        return result;
    }

    public List<Book> getAllBookByGenre2(Genre genre, String authorName){
        long start = System.currentTimeMillis();
        List<Book> result = this.bookRepository.getAllBooksByGenreUsingJPQL(genre, authorName);
        long end = System.currentTimeMillis();
        System.out.println("Time to execute jpql query - " + (end-start));

        return result;
    }

    public Book getBulkiestBookOfGenre(Genre genre, String author){
        return this.bookRepository.findTopByGenreAndAuthorNameOrderByTotalPagesDesc(genre, author);
    }
}
