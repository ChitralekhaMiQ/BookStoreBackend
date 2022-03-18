package com.example.backend.controller;

import com.example.backend.entity.Book;
import com.example.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookrepository;

    @GetMapping("/books")
    public List<Book> getContacts() {
        return bookrepository.findAll();
    }

    @PostMapping("/addBook")
    public List<Book> addBook(@RequestBody Book book){
        book.setImage(Base64.getEncoder().encodeToString(book.getImage().getBytes()));
        bookrepository.save(book);
        return bookrepository.findAll();
    };
}
