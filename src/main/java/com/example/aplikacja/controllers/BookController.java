package com.example.aplikacja.controllers;

import com.example.aplikacja.commands.BooksCommand;
import com.example.aplikacja.converters.BooksCommandToBooks;
import com.example.aplikacja.model.Books;
import com.example.aplikacja.repositories.AuthorRepository;
import com.example.aplikacja.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.aplikacja.repositories.BooksRepository;

@Controller
public class BookController {

    private BooksRepository booksRepository;
    private BooksCommandToBooks booksCommandToBooks;
    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    public BookController(BooksRepository booksRepository, BooksCommandToBooks booksCommandToBooks, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.booksCommandToBooks = booksCommandToBooks;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    @RequestMapping(value = {"/books" , "books/list"})
    public String getBooks(Model model) {
        model.addAttribute("books", booksRepository.findAll());
        return "books";
    }

    @GetMapping
    @RequestMapping("/books/{id}/show")
    public String getBooksDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("books", booksRepository.findById(id).get());
        return "books/show";
    }

    @GetMapping
    @RequestMapping("/books/{id}/delete")
    public String deleteBooks(@PathVariable("id") Long id) {
        booksRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping
    @RequestMapping("/books/new")
    public String newBooks(Model model){
        model.addAttribute("books", new BooksCommand());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("author", authorRepository.findAll());
        return "books/addedit";
    }

    @PostMapping("books")
    public String saveOrUpdate(@ModelAttribute BooksCommand command){
        BooksdetachedBooks = booksCommandToBooks.convert(command);
        Books savedBooks = booksRepository.save(detachedBooks);

        return "redirect:/books/" + savedBooks.getId() + "/show";
    }
}
