package com.dev.boot.bankservice.repository;

import com.dev.boot.bankservice.model.Account;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> getByUserPhoneNumber(String phoneNumber);
}
