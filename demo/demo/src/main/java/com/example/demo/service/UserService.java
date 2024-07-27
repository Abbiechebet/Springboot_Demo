package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAll();

    User findById(Long userId);

    User updateByUserId(User user);

    void deleteUser (Long userId);
}