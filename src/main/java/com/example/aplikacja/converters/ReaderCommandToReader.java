package com.example.aplikacja.converters;

import com.example.aplikacja.commands.ReaderCommand;
import lombok.Synchronized;
import com.example.aplikacja.model.Reader;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ReaderCommandToReader implements Converter<ReaderCommand, Reader> {
    @Synchronized
    @Nullable
    @Override
    public Reader convert(ReaderCommand source) {
        if (source == null) {
            return null;
        }

        final Reader reader = new Reader();
        reader.setId(source.getId());
        reader.setFirstName(source.getFirstName());
        reader.setLastName(source.getLastName());

        return reader;

    }
}
