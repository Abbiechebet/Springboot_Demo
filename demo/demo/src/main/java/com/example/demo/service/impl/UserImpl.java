package com.example.demo.service.impl;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAll(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public User updateByUserId(User user) {
        User existingUser = userRepository.findById(user.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + user.getUserId()));
        existingUser.setName(user.getName());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userid) {
        if (!userRepository.existsById(userid)) {
            throw new ResourceNotFoundException("User not found with id: " + userid);
        }
        userRepository.deleteById(userid);
    }
}


//    @Override
//    public User updateByUserId(User user) {
//        User existingUser = findById(user.getUserId());
//        existingUser.setName(user.getName());
//        return userRepository.save(existingUser);
//    }
