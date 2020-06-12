package com.example.aplikacja.controllers;

import com.example.aplikacja.commands.AuthorCommand;
import com.example.aplikacja.converters.AuthorCommandToAuthor;
import com.example.aplikacja.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.aplikacja.repositories.AuthorRepository;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;
    private com.example.aplikacja.repositories.BookRepository bookRepository;
    private AuthorCommandToAuthor authorCommandToAuthor;

    public AuthorController(AuthorRepository authorRepository, com.example.aplikacja.repositories.BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = {"/author", "/author/list"})
    public String getAuthor(Model model) {
        model.addAttribute("author", authorRepository.findAll());
        return "author/list";
    }

    @RequestMapping("/author/{id}/songs")
    public String getAuthorsBooks(Model model, @PathVariable("id") Long id) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            model.addAttribute("books", bookRepository.getAllByAuthorsIsContaining(author.get()));
            model.addAttribute("filter", "author: " + author.get().getFirstName() + " " + author.get().getLastName());
        } else {
            model.addAttribute("songs", new ArrayList<>());
            model.addAttribute("filter", "author for this id doesn't exist");
        }

        return "books/list";
    }

    @RequestMapping("/author/{id}/show")
    public String getAuthorDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("author", authorRepository.findById(id).get());
        return "authorshow";
    }

    @RequestMapping("/author{id}/delete")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
        return "redirect:/author";
    }
    @GetMapping
    @RequestMapping("/author/new")
    public String newBooks(Model model){
        model.addAttribute("author", new AuthorCommand());
        return "author/addedit";
    }

    @PostMapping("author")
    public String saveOrUpdate(@ModelAttribute AuthorCommand command){

        Optional<Author> authorOptional = authorRepository.getFirstByFirstNameAndLastName(command.getFirstName(), command.getLastName());

        if (!authorOptional.isPresent()) {
            Author detachedAuthor = authorCommandToAuthor.convert(command);
            Author savedAuthor = authorRepository.save(detachedAuthor);
            return "redirect:/author/" + savedAuthor.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such author in db");
            return "redirect:/author/" + authorOptional.get().getId() + "/show";
        }
    }
}
