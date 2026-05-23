package com.example.library_system.repositories;

import com.example.library_system.models.Book;
import com.example.library_system.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findByStudentId(Integer studentId); // select * from book where student_id = ?


    @Transactional
    @Modifying
    @Query("update Book b set b.student = ?2 where b.id = ?1")
    void updateBookAvailability(int bookId, Student student);

    /**
     * DDL - create table, alter table,
     * DML - insert, update, delete
     *
     */


    /**
     * Database Transaction
     *
     * 500   100    900
     * A    -->     B
     *
     * (400)        1000
     *
     * Op1             Op2
     * A - 100         B + 100
     *
     * The onus is on the user to handle the consistency of these 2 operations, i.e if any of them fails, roll back the effect of the other transaction as well
     *
     * Op1
     * /  | \
     * s1  s2 s3
     * update disk , update memory, cpu register
     */
}
