package com.example.aplikacja.repositories;

import com.example.aplikacja.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> getFirstByFirstNameAndLastName(String firstName, String lastName);
    Optional<Author> getFirstByFirstName(String firstName);
}
