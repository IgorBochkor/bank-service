package com.dev.boot.bankservice.service;

import com.dev.boot.bankservice.model.Account;
import java.util.List;

public interface AccountService {
    void save(Account account);

    List<Account> getAllByPhoneNumber(String phoneNumber);

    Account getByAccountNumber(String accountNumber);
}
