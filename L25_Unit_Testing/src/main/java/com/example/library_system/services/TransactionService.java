package com.example.library_system.services;

import com.example.library_system.dtos.CreateTxnRequest;
import com.example.library_system.dtos.Pair;
import com.example.library_system.models.*;
import com.example.library_system.repositories.TransactionRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    TransactionUtils transactionUtils;

    @Autowired
    BookService bookService;

    @Value("${books.return.due-date}")
    Integer returnDueDateThreshold;

    @Value("${books.fine-per-day}")
    Integer finePerDay;

    public Transaction initiateTxn(CreateTxnRequest createTxnRequest) throws BadRequestException {

        Pair bookStudentPair = getBookStudentPair(createTxnRequest.getStudentId(), createTxnRequest.getBookId());

        if(createTxnRequest.getTxnType() == TxnType.ISSUE){
            return initiateIssueTxn(createTxnRequest, bookStudentPair);
        }else{
            return initiateReturnTxn(createTxnRequest, bookStudentPair);
        }
    }

    private Transaction initiateIssueTxn(CreateTxnRequest createTxnRequest, Pair bookStudentPair) throws BadRequestException {

        /**
         * 1. Validate the incoming request
         *     a) Book should be present and student also be present
         *     b) Book is present and is not issued already to someone else / this particular student also
         *     c) Number of active issued books by the student should be < threshold mentioned in the config
         *
         * 2. Create a transaction with the status as pending in the txn table
         * 3. Book is marked unavailable / issued to student 's1'
         * 4. Update the transaction status to complete
         *
         * ---
         * if anything fails b/w step 3-4, then we will mark the transaction as failed and make the book available
         */


        if(bookStudentPair.getBook().getStudent() != null){
            throw new BadRequestException("Book is already issued to someone");
        }

        List<Book> issuedBooks = this.bookService.getBooksIssuedToStudent(createTxnRequest.getStudentId());

        if(issuedBooks != null && issuedBooks.size() >= this.transactionUtils.getMaxAllowedBooksForIssuance()){
            throw new BadRequestException("Student has already issued maximum number of books");
        }

        // ------------- Creating transaction -------------------------

        Transaction transaction = getTxnObjectInPendingState(createTxnRequest);
        transaction = this.transactionRepository.save(transaction); // created_on

        // ------------- Mark the book unavailable -------------


        try {
            // Option 1:
//        book.setStudent(student);
//        this.bookService.createBook(book);

            // Option 2:
            bookService.issueBookToStudent(createTxnRequest.getBookId(), bookStudentPair.getStudent());

            // --------- Complete the transaction ---------------

            transaction.setTxnStatus(TxnStatus.COMPLETED);
            // upsert
            transaction = this.transactionRepository.save(transaction); // Since the entity is already present, hibernate will do update and not insert
        }catch (Exception e){
            e.printStackTrace();
            transaction.setTxnStatus(TxnStatus.FAILED);
            this.transactionRepository.save(transaction); // updated_on

            bookStudentPair.getBook().setStudent(null); // Marking the book available
            this.bookService.createBook(bookStudentPair.getBook());
        }

        /**
         * Option 1 : calling the generic book save function because internally it's going to update the book as the entity is not new
         * Generic: Because you can update any of the fields
         *
         * Option 2: Explicitly creating a new function where we are updating only the student for a particular row
         * Specific: Because you are updating only the student field
         *
         */

        return transaction;

    }

    private Transaction initiateReturnTxn(CreateTxnRequest createTxnRequest, Pair bookStudentPair) throws BadRequestException {

        /**
         *
         *          * 1. Validate the incoming request
         *          *     a) Book should be present and student also be present
         *          *     b) Book is issued to the same student who is returning the book
         *          *
         *          *
         *          * 2. Create a transaction with the status as pending in the txn table
         *          * 3. Book is marked available / student column in the book table will be again set to null
         *            4. check the due date from the date of issuance, and impose the fine if applicable
         *          * 5. Update the transaction status to complete
         *          *
         *          * ---
         *          * if anything fails b/w step 3-4, then we will mark the transaction as failed and make the book unavailable once again and assign it back to the same student
         *
         */



        if(bookStudentPair.getBook().getStudent() == null ||
                (bookStudentPair.getBook().getStudent().getId() != null && !bookStudentPair.getBook().getStudent().getId().equals(createTxnRequest.getStudentId()))){
            throw new BadRequestException("Book is not issued to the student");
        }

        // Step 2
        Transaction transaction = getTxnObjectInPendingState(createTxnRequest);
        this.transactionRepository.save(transaction);

        try {

            // Step 3
            this.bookService.issueBookToStudent(bookStudentPair.getBook().getId(), null);

            // Step 4 (Fine calculation)
            Transaction issueTxn = this.transactionRepository.findTopByStudentIdAndBookIdAndTxnTypeAndTxnStatusOrderByIdDesc(
                    createTxnRequest.getStudentId(), createTxnRequest.getBookId(), TxnType.ISSUE, TxnStatus.COMPLETED);

            transaction.setFine(calculateFine(issueTxn.getCreatedOn()));


            transaction.setTxnStatus(TxnStatus.COMPLETED);
            this.transactionRepository.save(transaction);

        }catch (Exception e){
            e.printStackTrace();
            transaction.setTxnStatus(TxnStatus.FAILED);
            transaction.setFine(null);
            this.transactionRepository.save(transaction);

            // roll back the book de-allocation
            bookStudentPair.getBook().setStudent(bookStudentPair.getStudent());
            this.bookService.createBook(bookStudentPair.getBook());
        }

        return transaction;
    }


    // --- TODO: move these util functions to some other class probably txnServiceUtil ...
    private Pair getBookStudentPair(Integer studentId, Integer bookId) throws BadRequestException {
        Student student = this.studentService.getStudentDetails(studentId);
        Book book = this.bookService.getBookDetailsV2(bookId);

        if(book == null || student == null){
            throw new BadRequestException("either bookId or studentId is invalid");
        }

        return Pair.builder()
                .book(book)
                .student(student)
                .build();
    }

    private Transaction getTxnObjectInPendingState(CreateTxnRequest createTxnRequest){

        return Transaction.builder()
                .book(
                        Book.builder().id(createTxnRequest.getBookId()).build()
                )
                .student(
                        Student.builder().id(createTxnRequest.getStudentId()).build()
                )
                .txnType(createTxnRequest.getTxnType())
                .txnStatus(TxnStatus.PENDING)
                .build();
    }

    private long calculateFine(Date issueDate){

        long issueTimeInEpoch = issueDate.getTime();
        long currentTimeInEpoch = System.currentTimeMillis();

        long timeDiff = currentTimeInEpoch - issueTimeInEpoch;

        long daysPassed = TimeUnit.MILLISECONDS.toDays(timeDiff);

        if (daysPassed > returnDueDateThreshold) {
            return (daysPassed - returnDueDateThreshold) * finePerDay;
        }

        return 0;
    }

}
