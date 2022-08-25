package com.domo.securityexample.service;

import com.domo.securityexample.domain.Role;
import com.domo.securityexample.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
