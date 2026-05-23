package com.example.library_system.controllers;

import com.example.library_system.dtos.CreateTxnRequest;
import com.example.library_system.models.TxnType;
import com.example.library_system.services.TransactionService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    public Integer initiateTxn(@RequestBody @Valid CreateTxnRequest createTxnRequest) throws BadRequestException {
        return this.transactionService.initiateTxn(createTxnRequest).getId();
    }
}
