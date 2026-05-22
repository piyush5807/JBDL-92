package com.example.library_system.dtos;

import com.example.library_system.models.Book;
import com.example.library_system.models.Student;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pair {

    private Student student;
    private Book book;
}
