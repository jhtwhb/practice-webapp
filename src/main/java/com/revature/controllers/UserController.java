package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get All Users
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get User
    @GetMapping("/id")
    public ResponseEntity<User> getUser(int id) {
        if (userService.getUser(id).isPresent()) {
            return ResponseEntity.ok(userService.getUser(id).get());
        }
        return ResponseEntity.status(404).build();
    }

    // Register
    @PostMapping("/register")
    public User createUser(User u) {
        return userService.createUser(u);
    }

    // Login
    @PostMapping("/login")
    public void loginUser(@RequestBody User u) {
        userService.loginUser(u);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }

    // Edit
    @PutMapping("/update/{id}")
    public boolean updateUser(@RequestBody User u, int id) {
        return userService.updateUser(id, u);
    }

    @PutMapping("/update")
    public boolean updateSelf(User u) {
        return userService.updateUser(u);
    }
}
