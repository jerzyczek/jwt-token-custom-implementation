package com.mateusz.demoauth.service;

import com.mateusz.demoauth.domain.Role;
import com.mateusz.demoauth.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
