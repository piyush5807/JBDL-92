package com.example.library_system.services;

import com.example.library_system.models.Author;
import com.example.library_system.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author getOrCreateAuthor(Author author){
        Author authorFromDB = this.authorRepository.findByEmail(author.getEmail());
        if(authorFromDB == null){
            // we need to create the author because it does not exist in the db
            authorFromDB = createAuthor(author);
        }

        return authorFromDB;
    }

    public Author createAuthor(Author author){
        return this.authorRepository.save(author);
    }
}
