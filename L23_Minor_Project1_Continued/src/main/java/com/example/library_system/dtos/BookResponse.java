package com.example.library_system.dtos;

import com.example.library_system.models.Author;
import com.example.library_system.models.Book;
import com.example.library_system.models.Genre;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private String name;
    private Genre genre;
    private Author author;


    public static BookResponse from(Book book){
        return BookResponse.builder()
                .name(book.getName())
                .genre(book.getGenre())
                .author(book.getAuthor())
                .build();
    }


}
