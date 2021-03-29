package com.dev.boot.bankservice.service;

import com.dev.boot.bankservice.model.Account;
import com.dev.boot.bankservice.model.Transaction;
import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllByAccount(int page, int size, Account account);

    void transfer(Account fromAccount, Account toAccount, BigDecimal amount);
}
