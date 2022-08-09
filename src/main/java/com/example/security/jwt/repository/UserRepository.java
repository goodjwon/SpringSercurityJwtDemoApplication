package com.example.security.jwt.repository;

import com.example.security.jwt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
    User findByUserName(String userName);
}
