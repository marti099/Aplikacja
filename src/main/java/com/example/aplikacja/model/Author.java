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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;

    @ManyToMany(mappedBy = "author")
    private Set<Author> authors= new HashSet<>();

    public Author(){
    }
    public Author(String firstName, String lastName, String nick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nick = nick;
        this.authors = authors;
    }
}
