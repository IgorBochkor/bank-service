package com.dev.boot.bankservice.service.impl;

import com.dev.boot.bankservice.model.Account;
import com.dev.boot.bankservice.model.Transaction;
import com.dev.boot.bankservice.repository.TransactionRepository;
import com.dev.boot.bankservice.service.AccountService;
import com.dev.boot.bankservice.service.TransactionService;
import com.dev.boot.bankservice.service.util.ClientService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final ClientService clientService;

    @Override
    public List<Transaction> getAllByAccount(int page, int size, Account account) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("date")
                .descending().and(Sort.by("id")));
        return transactionRepository.getAllByAccount(account,pageRequest);
    }

    @Override
    @Transactional
    public void transfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        Transaction transactionFromAccount = new Transaction();
        transactionFromAccount.setAccountTo(toAccount);
        transactionFromAccount.setAccountFrom(fromAccount);
        transactionFromAccount.setAmount(amount);
        transactionFromAccount.setDateTime(LocalDateTime.now());
        transactionFromAccount.setTypeOperation(Transaction.TypeOperation.OUTCOMING);
        transactionRepository.save(transactionFromAccount);
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        if (fromAccount.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Not enough money on account " + fromAccount);
        }
        accountService.save(fromAccount);

        Transaction transactionToAccount = new Transaction();
        transactionToAccount.setAccountFrom(fromAccount);
        transactionToAccount.setAccountTo(toAccount);
        transactionToAccount.setDateTime(LocalDateTime.now());
        transactionToAccount.setTypeOperation(Transaction.TypeOperation.INCOMING);
        if (fromAccount.getCurrency() != toAccount.getCurrency()) {
            BigDecimal rate = clientService.getRate(LocalDate.now(),
                    fromAccount.getCurrency(), toAccount.getCurrency());
            amount = amount.multiply(rate);
        }
        transactionToAccount.setAmount(amount);
        transactionRepository.save(transactionToAccount);
        toAccount.setBalance(toAccount.getBalance().add(amount));
        accountService.save(toAccount);
    }
}
