package com.example.library_system.repositories;

import com.example.library_system.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByEmail(String email);
}
