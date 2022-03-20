package com.example.backend.controller;

import com.example.backend.entity.Book;
import com.example.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookrepository;

    @GetMapping("/books")
    public List<Book> getContacts() {
        return bookrepository.findAll();
    }

    @PostMapping("/addBook")
    public List<Book> addBook(@RequestPart Book book, @RequestPart("image") MultipartFile imageFile) throws IOException {
        book.setImage(imageFile.getBytes());
        bookrepository.save(book);
        return bookrepository.findAll();
    };

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Integer id) {
        Optional<Book> bookEntity = bookrepository.findById(id);
        Book deleteBook = bookEntity.get();
        bookrepository.delete(deleteBook);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
