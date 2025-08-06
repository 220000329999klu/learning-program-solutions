package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUser() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setName("Arman");

        when(userService.getUserById(1L)).thenReturn(user);

        // Act
        ResponseEntity<User> response = userController.getUser(1L);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Arman", response.getBody().getName());
    }
}