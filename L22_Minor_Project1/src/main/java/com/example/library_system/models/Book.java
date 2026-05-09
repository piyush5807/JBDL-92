package com.example.library_system.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

// ----------------- Lombok dependencies ---------------------------
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

// ----------------- JPA AND Hibernate ------------------------------

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Genre genre;

    // JPA joins -- How to define relationships b/w different entities at a JPA level (foreign keys)
}
