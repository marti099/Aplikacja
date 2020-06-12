package com.example.aplikacja.repositories;

import com.example.aplikacja.model.Books;
import com.example.aplikacja.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> getAllByArtistsIsContaining(Books books);
    Optional<Category> getCategoryByName(String name);

}
