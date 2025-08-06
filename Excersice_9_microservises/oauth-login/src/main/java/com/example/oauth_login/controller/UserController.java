package com.example.oauth_login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal; // returns user info from OAuth2
    }

    @GetMapping("/")
    public String home() {
        return "Welcome! Go to /user to see user info.";
    }
}