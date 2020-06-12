package com.example.aplikacja.converters;


import com.example.aplikacja.commands.AuthorCommand;
import lombok.Synchronized;
import com.example.aplikacja.model.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class AuthorCommandToAuthor implements Converter<AuthorCommand, Author> {
    @Synchronized
    @Nullable

    @Override
    public Author convert(AuthorCommand source) {
        if (source == null) {
            return null;
        }
        final Author author = new Author();
        author.setId(source.getId());
        author.setFirstName(source.getFirstName());
        author.setLastName(source.getLastName());
        author.setNick(source.getNick());

        return author;


    }
}