package com.example.repository;

import com.example.security.jwt.domain.Role;
import com.example.security.jwt.domain.User;
import com.example.security.jwt.repository.RoleRepository;
import com.example.security.jwt.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testFindByUserName() {
        //when
        User user = userRepository.findByUserName("Jung Park");
        //then
        assert user.getUserName().equals("Jung Park");
    }

    @Test
    public void testFindByRoleName() {
        //when
        Role role = roleRepository.findByRoleName("ROLE_USER");
        //then
        assert role.getRoleName().equals("ROLE_USER");
    }
}
