package com.example.demo.service;

import com.example.demo.UserPrincipal;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new UserPrincipal(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println("LOGIN ATTEMPT: " + username);

        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("USER FOUND: " + user.getUsername());
        System.out.println("PASSWORD IN DB: " + user.getPassword());

        return new UserPrincipal(user);
    }

}
