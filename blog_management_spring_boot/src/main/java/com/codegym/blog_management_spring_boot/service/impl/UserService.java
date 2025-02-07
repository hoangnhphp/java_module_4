package com.codegym.blog_management_spring_boot.service.impl;

import com.codegym.blog_management_spring_boot.model.User;
import com.codegym.blog_management_spring_boot.repository.IUserRepository;
import com.codegym.blog_management_spring_boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User s) {
        userRepository.save(s);
    }

    @Override
    public void update(Long id, User s) {
        User u = userRepository.findById(id).orElse(null);
        if (u != null) {
            u.setId(id);
            userRepository.save(u);
        }
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findByName(String name) {
        return List.of();
    }
}
