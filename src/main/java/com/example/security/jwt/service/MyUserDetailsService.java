package com.example.security.jwt.service;

import com.example.security.jwt.domain.User;
import com.example.security.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService {
    UserRepository userRepository;

    public Optional<User> findByIdPw(String id) {
        return userRepository.findById(id);
    }
}
