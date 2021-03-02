package com.dev.boot.bankservice.service.impl;

import com.dev.boot.bankservice.model.User;
import com.dev.boot.bankservice.repository.UserRepository;
import com.dev.boot.bankservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).get();
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
