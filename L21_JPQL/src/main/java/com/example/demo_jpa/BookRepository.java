package com.example.demo_jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // JPA allows you to write your own query which you want to be executed when a specific function is called


    @Query(value = "select * from book where book_genre = :g and author_name = :author", nativeQuery = true)
    List<Book> getAllBooksByGenre(Genre g, String author);

    @Query("select b from Book b where b.genre = ?1 and b.authorName = :author")
    List<Book> getAllBooksByGenreUsingJPQL(Genre g, String author);

    // Find the book with the most number of pages having genre as TECHNOLOGY
//    @Query("select b from Book b where b.genre = ?1 order by b.totalPages desc limit 1")
//    Book findBulkiestBook(Genre genre);

    Book findTopByGenreAndAuthorNameOrderByTotalPagesDesc(Genre genre, String authorName);


}



// insert into
// select *
// delete from
