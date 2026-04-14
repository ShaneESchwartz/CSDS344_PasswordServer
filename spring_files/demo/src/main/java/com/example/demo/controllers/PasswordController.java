package com.example.demo.controllers;

import com.example.demo.model.Password;
import com.example.demo.repositories.PasswordRepository;
import com.example.demo.service.PasswordService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;
import java.util.List;

@RestController
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/passwords")
    public ResponseEntity<Void> savePasswords(@RequestBody Password password, Authentication authentication) {
        String username = authentication.getName();
        passwordService.savePassword(password, username);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/passwords")
    public List<Password> getPasswords(Authentication authentication) {
        String username = authentication.getName();
        return passwordService.getPasswords(username);
    }

}
