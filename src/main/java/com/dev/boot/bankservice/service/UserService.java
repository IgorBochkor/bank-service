package com.dev.boot.bankservice.service;

import com.dev.boot.bankservice.model.User;

public interface UserService {
    User save(User user);

    User get(Long id);

    User findByPhoneNumber(String phoneNumber);

    void remove(Long id);
}
