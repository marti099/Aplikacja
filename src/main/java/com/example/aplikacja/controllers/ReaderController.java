package com.example.aplikacja.controllers;


import com.example.aplikacja.commands.ReaderCommand;
import com.example.aplikacja.model.Reader;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.aplikacja.repositories.ReaderRepository;

import java.util.Optional;

public class ReaderController {
    private ReaderRepository readerRepository;

    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }


    @RequestMapping(value = {"/readers", "/reader/list"})
    public String getReaders(Model model) {
        model.addAttribute("readers", readerRepository.findAll());
        return "reader/list";
    }

    @RequestMapping("/reader/{id}/show")
    public String getReaderDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("reader", readerRepository.findById(id).get());
        return "reader/show";
    }

    @RequestMapping("/reader/{id}/delete")
    public String deleteReader(@PathVariable("id") Long id) {
        readerRepository.deleteById(id);
        return "redirect:/readers";
    }

    @GetMapping
    @RequestMapping("/reader/new")
    public String newBooks(Model model){
        model.addAttribute("reader", new ReaderCommand());
        return "reader/addedit";
    }

    /*

    @PostMapping("reader")
    public String saveOrUpdate(@ModelAttribute ReaderCommand command){

        Optional<Reader> readerOptional = readerRepository.getReaderByName(command.());

        if (!readerOptional.isPresent()) {
            //tutaj wgl nie miałaś importu, dodałem już go, poza tym ważne jest to, czy piszesz z dużej czy małej litery
            Reader detachedReader = com.example.aplikacja.converters.ReaderCommandToReader.convert(command);
            Reader savedReader = readerRepository.save(detachedReader);
            return "redirect:/reader/" + savedReader.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such reader in db");
            return "redirect:/reader/" + readerOptional.get().getId() + "/show";
        }
    }
    */
}
