package com.dev.boot.bankservice.repository;

import com.dev.boot.bankservice.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u from User u join fetch u.roles where u.phoneNumber = ?1")
    Optional<User> findByPhoneNumber(String phoneNumber);

    @Override
    @Query(value = "SELECT u from User u join fetch u.roles where u.id = ?1")
    Optional<User> findById(Long id);
}
