package com.example.aplikacja.repositories;

import com.example.aplikacja.model.Author;
import com.example.aplikacja.model.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BooksRepository extends CrudRepository<Books, Long> {
    Optional<Books> getBooksByName(String name);

    Object getAllByAuthorsIsContaining(Author author);
}
