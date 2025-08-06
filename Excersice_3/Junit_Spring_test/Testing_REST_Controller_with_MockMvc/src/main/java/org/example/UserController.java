package org.example;

import java.util.List;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> fetchUsers() {
        return userService.getAllUsers();
    }

    public User registerUser(User user) {
        return userService.addUser(user);
    }
}