package com.example.aplikacja.converters;


import com.example.aplikacja.commands.CategoryCommand;
import lombok.Synchronized;
import com.example.aplikacja.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }
        final Category category = new Category();
        category.setId(source.getId());
        category.setName(source.getName());
        category.setGroupAge(source.getGroupAge());

        return category;

    }
}
