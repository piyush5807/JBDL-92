package com.example.demo_jpa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank   // @NotNull + Checking if the string is empty or not
//    @NotNull
    private String name;

    @NotNull
    private Genre genre;

    private Integer pages;
    private String authorName;

    public Book to(){
        return Book.builder()
                .name(this.name)
                .genre(this.genre)
                .totalPages(this.pages)
                .authorName(this.authorName)
                .build();

//        return new Book(null, this.name, this.genre, this.pages, this.authorName, null, null);
    }

}
