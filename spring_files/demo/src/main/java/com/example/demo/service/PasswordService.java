package com.example.demo.service;

import com.example.demo.model.Password;
import com.example.demo.model.User;
import com.example.demo.repositories.PasswordRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private UserRepository userRepository;

    public void savePassword(Password password, String username) {

        User user = userRepository.findByUsername(username);

    }

}
