package com.example.aplikacja.repositories;

import com.example.aplikacja.model.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReaderRepository extends CrudRepository<Reader, Long> {
    Optional<Reader> getFirstByFirstNameAndLastName(String firstName, String lastName);
    Optional<Reader> getFirstByFirstName(String firstName);
}
