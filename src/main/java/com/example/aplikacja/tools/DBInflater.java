package com.example.aplikacja.tools;

import com.example.aplikacja.model.Author;
import com.example.aplikacja.model.Category;
import com.example.aplikacja.model.Reader;
import com.example.aplikacja.model.Book;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.example.aplikacja.repositories.AuthorRepository;
import com.example.aplikacja.repositories.CategoryRepository;
import com.example.aplikacja.repositories.ReaderRepository;


@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {
    public DBInflater (AuthorRepository authorRepository, com.example.aplikacja.repositories.BookRepository bookRepository, CategoryRepository categoryRepository, ReaderRepository readerRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.readerRepository = readerRepository;
    }
    private AuthorRepository authorRepository;
    private com.example.aplikacja.repositories.BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private ReaderRepository readerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData() {
        com.example.aplikacja.model.Author nicholas_sparks = new com.example.aplikacja.model.Author ("Nicholas Charles", "Sparks", "Nicholas Sparks");
        com.example.aplikacja.model.Book theNotebook = new com.example.aplikacja.model.Book("The Notebook");
        com.example.aplikacja.model.Category romanticNovels = new com.example.aplikacja.model.Category ("Romantic Novels");
        com.example.aplikacja.model.Reader martaSkupien= new com.example.aplikacja.model.Reader( "Marta Skupień");

        //getBooks nie jest zdefiniowane
        //powinno być zdefiniowane src/main/java/com/example/aplikacja/controllers/<nazwaKontrolera>Controller.java
        //tam adnotacja z @RequestMapping("books")
        
        nicholas_sparks.getBooks().add(theNotebook);
        theNotebook.getAuthors().add(nicholas_sparks);
        authorRepository.save(nicholas_sparks);
        bookRepository.save(theNotebook);
        categoryRepository.save(romanticNovels);
        readerRepository.save(martaSkupien);

        com.example.aplikacja.model.Author colleen_hoover = new com.example.aplikacja.model.Author ("Margaret Colleen", "Fennell", "Colleen Hoover");
        com.example.aplikacja.model.Book hopeless = new com.example.aplikacja.model.Book("Hopeless");
        com.example.aplikacja.model.Category youthNovels = new com.example.aplikacja.model.Category ("Youth Novels");
        com.example.aplikacja.model.Reader annaKowalska= new com.example.aplikacja.model.Reader( "Anna Kowalska");
        colleen_hoover.getBooks().add(hopeless);
        hopeless.getAuthors().add(colleen_hoover);
        authorRepository.save(colleen_hoover);
        bookRepository.save(hopeless);
        categoryRepository.save(youthNovels);
        readerRepository.save(annaKowalska);

        com.example.aplikacja.model.Author j_k__rowling = new com.example.aplikacja.model.Author ("Joanne", "Murray", "J.K. Rowling");
        com.example.aplikacja.model.Book harry_potter = new com.example.aplikacja.model.Book("Harry Potter");
        com.example.aplikacja.model.Category fantasy = new com.example.aplikacja.model.Category ("Fantasy");
        com.example.aplikacja.model.Reader janNowak = new com.example.aplikacja.model.Reader( "Jan Nowak");
        j_k__rowling.getBooks().add(harry_potter);
        harry_potter.getAuthors().add(j_k__rowling);
        authorRepository.save(j_k__rowling);
        bookRepository.save(harry_potter);
        categoryRepository.save(fantasy);
        readerRepository.save(janNowak);

    }


}
