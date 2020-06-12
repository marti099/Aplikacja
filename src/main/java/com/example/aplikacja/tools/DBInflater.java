package com.example.aplikacja.tools;

import com.example.aplikacja.model.Author;
import com.example.aplikacja.model.Books;
import com.example.aplikacja.model.Category;
import com.example.aplikacja.model.Reader;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.example.aplikacja.repositories.AuthorRepository;
import com.example.aplikacja.repositories.BooksRepository;
import com.example.aplikacja.repositories.CategoryRepository;
import com.example.aplikacja.repositories.ReaderRepository;


@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {
    public DBInflater (AuthorRepository authorRepository, BooksRepository booksRepository, CategoryRepository categoryRepository, ReaderRepository readerRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
        this.categoryRepository = categoryRepository;
        this.readerRepository = readerRepository;
    }
    private AuthorRepository authorRepository;
    private BooksRepository booksRepository;
    private CategoryRepository categoryRepository;
    private ReaderRepository readerRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData() {
        Author nicholas_sparks = new Author ("Nicholas Charles", "Sparks", "Nicholas Sparks");
        Books theNotebook = new Books("The Notebook");
        Category romanticNovels = new Category ("Romantic Novels");
        Reader martaSkupien= new Reader( "Marta Skupień");
        nicholas_sparks.getBooks().add(theNotebook);
        theNotebook.getAuthor().add(nicholas_sparks);
        authorRepository.save(nicholas_sparks);
        booksRepository.save(theNotebook);
        categoryRepository.save(romanticNovels);
        readerRepository.save(martaSkupien);

        Author colleen_hoover = new Author ("Margaret Colleen", "Fennell", "Colleen Hoover");
        Books hopeless = new Books("Hopeless");
        Category youthNovels = new Category ("Youth Novels");
        Reader annaKowalska= new Reader( "Anna Kowalska");
        colleen_hoover.getBooks().add(hopeless);
        hopeless.getAuthor().add(colleen_hoover);
        authorRepository.save(colleen_hoover);
        booksRepository.save(hopeless);
        categoryRepository.save(youthNovels);
        readerRepository.save(annaKowalska);

        Author j_k__rowling = new Author ("Joanne", "Murray", "J.K. Rowling");
        Books harry_potter = new Books("Harry Potter");
        Category fantasy = new Category ("Fantasy");
        Reader janNowak = new Reader( "Jan Nowak");
        j_k__rowling.getBooks().add(harry_potter);
        harry_potter.getAuthor().add(j_k__rowling);
        authorRepository.save(j_k__rowling);
        booksRepository.save(harry_potter);
        categoryRepository.save(fantasy);
        readerRepository.save(janNowak);

    }


}
