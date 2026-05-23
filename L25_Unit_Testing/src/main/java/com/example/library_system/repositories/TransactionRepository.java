package com.example.library_system.repositories;

import com.example.library_system.models.Transaction;
import com.example.library_system.models.TxnStatus;
import com.example.library_system.models.TxnType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findTopByStudentIdAndBookIdAndTxnTypeAndTxnStatusOrderByIdDesc(Integer studentId,
                                                                               Integer bookId, TxnType txnType,
                                                                               TxnStatus txnStatus);
}
