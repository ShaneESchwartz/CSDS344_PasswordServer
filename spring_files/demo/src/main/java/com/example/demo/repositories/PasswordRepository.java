package com.example.demo.repositories;

import com.example.demo.model.Password;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PasswordRepository  extends JpaRepository<Password, Long> {
    List<Password> findByUser(User user);
}
