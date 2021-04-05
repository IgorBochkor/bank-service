package com.dev.boot.bankservice.service.impl;

import com.dev.boot.bankservice.model.Account;
import com.dev.boot.bankservice.repository.AccountRepository;
import com.dev.boot.bankservice.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> getByPhoneNumber(String phoneNumber) {
        return accountRepository.getByUserPhoneNumber(phoneNumber);
    }

    @Override
    public Account getAllByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).get();
    }
}
