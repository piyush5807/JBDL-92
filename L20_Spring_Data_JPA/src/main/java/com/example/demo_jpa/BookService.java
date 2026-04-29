package com.example.demo_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Integer createBook(CreateBookRequest createBookRequest){

        Book book = createBookRequest.to();
        book = bookRepository.save(book); // save function internally changes the input data as well in addition to returning the result from Spring boot 3.X onwards

        return book.getId();
    }
}
