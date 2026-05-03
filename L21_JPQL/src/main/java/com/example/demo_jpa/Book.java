package com.example.demo_jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter // 3 getters - id, name, getGenre
@Setter // 3 setters - id, name, setGenre
@AllArgsConstructor // 1 all args constructor
@NoArgsConstructor // 1 default constructor
@Builder
@Entity
//@Table(name = "my_table")
public class Book {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Underlying db
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; // auto incremented

//    @Column(name = "title", nullable = false)
    private String name;

    @Column(name = "book_genre")
    private Genre genre;

    private Integer totalPages; // pages --> totalPages
    private String authorName;

    private BookType bookType;

    @CreationTimestamp //
    private Date createdAt; // This will be set by hibernate (for now assume by db just like id)

    @UpdateTimestamp
    private Date updatedAt; // This will be set by hibernate (for now assume by db just like id)





//    public static void main(String[] args) {
////        Book b = new Book();
////        b.setGenre(Genre.FICTIONAL);
////        b.setName("Sample book");
//
//        Book b2 = new Book(null, "Sample book", Genre.FICTIONAL);
//
//        Book b3 = Book
//                .builder()
//                .name("Three Muskeeters")
//                .genre(Genre.NON_FICTIONAL)
//                .build();
//
//        b3.getId();
//
//        Book b4 = Book.builder().build();
//
//
//        List<Integer> al = Arrays.asList(1, 2, 3, 4);
//
//        al.stream()
//                .filter(x -> x % 2 == 0)
//                .map(x -> x*x)
//                .forEach(x -> System.out.println(x));
//    }
}
