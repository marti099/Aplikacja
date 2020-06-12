package com.example.aplikacja.converters;

import com.example.aplikacja.commands.BooksCommand;
import lombok.Synchronized;
import com.example.aplikacja.model.Books;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BooksCommandToBooks implements Converter<BooksCommand, Books> {
    @Synchronized
    @Nullable
    @Override
    public Books convert(BooksCommand source) {
        if (source == null) {
            return null;
        }
        final Books books = new Books();
        books.setId(source.getId());
        books.setTitle(source.getTitle());
        books.setYear(source.getYear());
        books.setPublisher(source.getPublisher());

        return books;

    }
}