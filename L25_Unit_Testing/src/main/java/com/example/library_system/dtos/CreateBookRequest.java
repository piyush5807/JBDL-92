package com.example.library_system.dtos;

import com.example.library_system.models.Author;
import com.example.library_system.models.Book;
import com.example.library_system.models.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank
    private String name;
    private Genre genre;

//    private CreateAuthorRequest authorRequest;

    // Author details
    @NotBlank
    private String authorName;

    @NotBlank
    @Email
    private String authorEmail;

    private String authorCountry;


    public Book to(){
        return Book.builder()
                .genre(this.genre)
                .name(this.name)
                .author(
                        Author.builder()
                                .name(this.authorName)
                                .country(this.authorCountry)
                                .email(this.authorEmail)
                                .build()
                ).build();
    }

}
