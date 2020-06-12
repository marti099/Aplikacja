package com.example.aplikacja.controllers;

import com.example.aplikacja.commands.CategoryCommand;
import com.example.aplikacja.converters.CategoryCommandToCategory;
import com.example.aplikacja.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.aplikacja.repositories.CategoryRepository;

import java.util.Optional;


@Controller
public class CategoryController {

    private CategoryRepository categoryRepository;
    private CategoryCommandToCategory categoryCommandToCategory;

    public CategoryController(CategoryRepository categoryRepository, CategoryCommandToCategory categoryCommandToCategory) {
        this.categoryRepository = categoryRepository;
        this.categoryCommandToCategory = categoryCommandToCategory;
    }

    @RequestMapping(value = {"/categories", "/category/list"})
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/list";
    }

    @RequestMapping("/category/{id}/show")
    public String getCategoryDetails(Model model, @PathVariable("id") Long id) {
        model.addAttribute("category", categoryRepository.findById(id).get());
        return "category/show";
    }

    @RequestMapping("/category/{id}/delete")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryRepository.deleteById(id);
        return "redirect:/categories";
    }

    @GetMapping
    @RequestMapping("/category/new")
    public String newBooks(Model model){
        model.addAttribute("category", new CategoryCommand());
        return "category/addedit";
    }

    @PostMapping("category")
    public String saveOrUpdate(@ModelAttribute CategoryCommand command){

        Optional<Category> categoryOptional = categoryRepository.getCategoryByName(command.getName());

        if (!categoryOptional.isPresent()) {
            Category detachedCategory = categoryCommandToCategoryconvert(command);
            Category savedCategory = categoryRepository.save(detachedCategory);
            return "redirect:/category/" + savedCategory.getId() + "/show";
        } else {
            //TODO: error message to template
            System.out.println("Sorry, there's such category in db");
            return "redirect:/category/" + categoryOptional.get().getId() + "/show";
        }
    }
}
