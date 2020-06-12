package com.example.aplikacja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.aplikacja.repositories.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    @RequestMapping(value = {"/books" , "book/list"})
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }
}
