package com.example.aplikacja.repositories;

import com.example.aplikacja.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<com.example.aplikacja.model.Book, Long> {
    Optional<com.example.aplikacja.model.Book> getBooksByName(String name);

    Object getAllByAuthorsIsContaining(Author author);
}
