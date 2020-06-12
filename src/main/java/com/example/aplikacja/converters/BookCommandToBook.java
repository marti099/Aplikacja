
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class BookCommandToBook implements Converter<com.example.aplikacja.commands.BookCommand, com.example.aplikacja.model.Book> {
    
    private com.example.aplikacja.repositories.AuthorRepository authorRepository;

    public BookCommandToBook(com.example.aplikacja.repositories.AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public com.example.aplikacja.model.Book convert(com.example.aplikacja.commands.BookCommand source) {
        if (source == null) {
            return null;
        }

        final com.example.aplikacja.model.Book book = new com.example.aplikacja.model.Book();



        Optional<com.example.aplikacja.model.Author> author = authorRepository.findById(source.getAuthorId());

        if (author.isPresent()) {
            book.getAuthors().add(author.get());
        }

        return book;
    }
}