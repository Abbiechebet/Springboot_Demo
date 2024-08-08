package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAll(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size) {
        Page<User> users = userService.getAll(page, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("{userId}")
    public ResponseEntity<User> updateById(@PathVariable Long userId,
                                           @RequestBody User user){
        user.setUserId(userId);
        User updatedUser = userService.updateByUserId(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


//package com.example.demo.controller;
//
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping("/new")
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
//}
