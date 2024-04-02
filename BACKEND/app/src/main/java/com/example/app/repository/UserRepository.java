package com.example.app.repository;

import com.example.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndActiveTrue(String email);
    User findByPhoneAndActiveTrue(String phone);
    boolean existsByEmailAndActiveTrue(String email);
    boolean existsByPhoneAndActiveTrue(String phone);
    boolean existsByUserNameAndActiveTrue(String userName);
}
