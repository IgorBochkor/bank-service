package com.dev.boot.bankservice.repository;

import com.dev.boot.bankservice.model.Account;
import com.dev.boot.bankservice.model.Transaction;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("FROM Transaction t where t.accountTo = ?1 OR t.accountFrom = ?1")
    List<Transaction> getAllByAccount(Account account, Pageable pageRequest);
}
