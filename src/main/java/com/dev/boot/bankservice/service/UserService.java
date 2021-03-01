package com.dev.boot.bankservice.service;

import com.dev.boot.bankservice.model.User;

public interface UserService {
    User create(User user);

    User get(Long id);

    User update(User user);

    User findByPhoneNumber(String phoneNumber);

    void remove(Long id);
}
