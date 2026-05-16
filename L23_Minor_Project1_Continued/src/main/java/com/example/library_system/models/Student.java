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
public class Student {

    /**
     * 1. Integers occupy less space as compared to strings (Integer - 4/8 , Strings - can take more)
     */

    /**
     * If I create an index on book name, which operation will become heavier
     * 1. Insert the book
     * 2. Get the book by book name
     *
     * 13 > 6 ? t1
     * wdefrf > acdtgvtrgv ? t2
     *
     * wdefrf > wdefrg
     *
     * Conclusion : String comparisons can be time taking
     *
     * O(logN * M)
     *
     * 134233933
     *
     * 1
     * 100000001
     * 100000002
     * 100000003
     *
     * 2000000
     *
     * 214,74,83,647
     * 50,00,00,000 -- unique
     *
     *
     * [1, 3, 5, 6, 9, 10, 20]
     * To be inserted - 13
     * O(logN)
     *
     * ["abcerrf", "wdefrf", "wedefrfrfrf]
     * To be inserted - acdtgvtrgv
     *
     * O(logN)
     *
     * String s = 1:2:3:4:5;
     * s.split(:)
     *
     */



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    @Enumerated
    private Department department;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
