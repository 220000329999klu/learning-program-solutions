package org.example;

import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserService {
    public String getUserById(Long id) {
        if (id == 1L) {
            return "John Doe";
        } else {
            throw new NoSuchElementException("User not found");
        }
    }
}