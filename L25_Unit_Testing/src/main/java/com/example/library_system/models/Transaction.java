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
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    private TxnType txnType;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private TxnStatus txnStatus;

    @JoinColumn
    @ManyToOne
    private Book book;  // book_id

    @JoinColumn
    @ManyToOne
    private Student student; // student_id

    private Long fine; // only present when the book is returned after the due date

    /**
     * O1 -->    S1 --> B1   (t1)  Issue   Due date --> t1'
     * O2 -->    S1 --> B1   (t2)  Return  (t1' < t2 ? fine is applicable)
     *
     * select * from order where student_id = s1 and book_id = b1 and order_type = 'ISSUE' order by desc limit 1
     */
}
