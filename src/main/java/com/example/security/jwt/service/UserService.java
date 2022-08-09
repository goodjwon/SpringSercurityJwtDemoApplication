package com.example.security.jwt.service;

import com.example.security.jwt.domain.Role;
import com.example.security.jwt.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);
    User getUser(String userName);
    List<User> getUsers();

}
