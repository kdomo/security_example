package com.domo.securityexample.service;

import com.domo.securityexample.domain.Role;
import com.domo.securityexample.domain.User;
import com.domo.securityexample.repository.RoleRepository;
import com.domo.securityexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional @Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {}" , user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}" , role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}" , roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {}", userName);
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching All users");
        return userRepository.findAll();
    }
}
