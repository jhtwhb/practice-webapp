package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public User getUser(long id) {
        return userService.getUser(id);
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
    public void deleteUser(long id) {
        userService.deleteUser(id);
    }

    // Edit
    @PutMapping("/update/{id}")
    public boolean updateUser(@RequestBody User u, long id) {
        return userService.updateUser(id, u);
    }

    @PutMapping("/update")
    public boolean updateSelf(User u) {
        return userService.updateUser(u);
    }
}
