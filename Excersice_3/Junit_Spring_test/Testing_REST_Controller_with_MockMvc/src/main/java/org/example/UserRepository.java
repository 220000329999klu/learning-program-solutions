package org.example;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User save(User user);
}