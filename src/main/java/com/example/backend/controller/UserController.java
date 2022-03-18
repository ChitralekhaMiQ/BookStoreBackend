package com.example.backend.controller;

import antlr.StringUtils;
import com.example.backend.entity.Book;
import com.example.backend.entity.User;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.UserRepository;
import jdk.net.SocketFlow;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {
    @Autowired
    private UserRepository userrepository;

    @PostMapping("/signUp")
    public User insertUsers(@RequestBody User user)
    {
        return userrepository.save(user);
    }

}
