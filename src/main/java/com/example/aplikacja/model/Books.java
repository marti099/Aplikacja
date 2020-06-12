package com.example.aplikacja.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String year;
    private String publisher;
    @ManyToMany(mappedBy = "books")
    private Set<Books> books = new HashSet<>();

    public Books (){
    }
    public Books(String title) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.books = books;
    }
}
