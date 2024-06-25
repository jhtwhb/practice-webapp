package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        // Check user role
        // TODO : Role check

        return userDAO.findAll();
    }

    public Optional<User> getUser(int id) {
        return userDAO.findById(id);
    }

    public User createUser(User u) {
        return userDAO.save(u);
    }

    public void loginUser(User u) {

    }

    public void deleteUser(int id) {
        // Check user role
        // TODO : Role check

        userDAO.deleteById(id);
    }

    // Update self -- Self *should* exist though
    public boolean updateUser(User u) {
        // **Should** exist
        Optional<User> optUser = userDAO.findById(u.getUserId());

        if (optUser.isEmpty()) {
            return false;
        }
        User user = optUser.get();

        // Name
        if (user.getName().equals(u.getName())) {
            user.setName(u.getName());
        }

        // Password
        if (user.getPassword().equals(u.getPassword())) {
            user.setPassword(u.getPassword());
        }

        // Role
        if (user.getRole().equals(u.getRole())) {
            user.setRole(u.getRole());
        }

        userDAO.save(user);
        return true;
    }

    public boolean updateUser(int id, User u) {
        // Check user role
        // TODO : Role check

        // Item exists?
        Optional<User> optUser = userDAO.findById(id);

        if (optUser.isEmpty()) {
            return false;
        }
        User user = optUser.get();

        // Name
        if (user.getName().equals(u.getName())) {
            user.setName(u.getName());
        }

        // Password
        if (user.getPassword().equals(u.getPassword())) {
            user.setPassword(u.getPassword());
        }

        // Role
        if (user.getRole().equals(u.getRole())) {
            user.setRole(u.getRole());
        }

        userDAO.save(user);
        return true;
    }
}
