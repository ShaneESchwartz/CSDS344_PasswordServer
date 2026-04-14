package com.example.demo.service;

import com.example.demo.model.Password;
import com.example.demo.model.User;
import com.example.demo.repositories.PasswordRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private UserRepository userRepository;

   public void savePassword(Password password, String username) {

        User user = userRepository.findUserByUsername(username);
        password.setUser(user);
        passwordRepository.save(password);
   }

    public List<Password> getPasswords(String username) {
       User user = userRepository.findUserByUsername(username);
       return passwordRepository.findByUser(user);
   }

}
