package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User createUser(User user);
    Page<User> getAll(int page, int size);

    User findById(Long userId);

    User updateByUserId(User user);

    void deleteUser (Long userId);
}