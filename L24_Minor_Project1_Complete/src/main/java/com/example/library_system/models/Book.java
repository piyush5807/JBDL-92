package com.example.library_system.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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

    @Column(nullable = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    // JPA joins -- How to define relationships b/w different entities at a JPA level (foreign keys)
    @JoinColumn // this annotation makes a new column in the table and put the primary of the below object as the foreign key in this table
    @ManyToOne
    private Author author; // id field in author table will become the foreign key here.

    @JoinColumn
    @ManyToOne
    private Student student;

    /**
     * Ques: You need to find all the books which are written john.doe@gmail.com
     *
     * Option1: select b from book b where b.author_email = ? O(logn) // n is the number of books
     *
     * Option2: select b from book b, author a where b.author_id = a.id and a.email = ? // TODO: ...
     */


    /**
     * OneToOne
     * OneToMany
     * ManyToOne
     * ManyToMany
     *
     */

    // select * from book where id = 1
}
