package com.stasio.database.service;

import com.stasio.database.model.Transaction;
import com.stasio.database.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transactionService")
public class TransactionService {

    private final TransactionRepository transactionRepository;


    @Autowired
    public TransactionService(@Qualifier("transactionRepository") TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction getTransactionById(Long id) {
        return transactionRepository.getTransactionById(id);
    }
}
