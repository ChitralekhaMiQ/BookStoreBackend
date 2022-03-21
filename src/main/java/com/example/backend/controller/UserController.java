package com.example.backend.controller;

import com.example.backend.entity.User;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.UserRepository;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private BookRepository bookrepository;

    @PostMapping("/signUp")
    public User insertUsers(@RequestBody User user)
    {
        return userrepository.save(user);
    }


}
