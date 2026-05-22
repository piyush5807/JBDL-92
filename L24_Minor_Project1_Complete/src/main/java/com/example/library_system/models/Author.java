package com.example.library_system.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

// ----------------- Lombok dependencies ---------------------------
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

// ----------------- JPA AND Hibernate ------------------------------

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    private String country;

    @CreationTimestamp
    private Date createdOn;

//    private List<Book> books; (Not needed in case of uni-directional relationships)


}
