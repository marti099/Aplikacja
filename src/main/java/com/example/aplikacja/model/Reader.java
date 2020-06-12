package com.example.aplikacja.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "readers")
    private Set<Reader> readers= new HashSet<>();

    public Reader() {
    }

    public Reader(String firstName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.readers = readers;
    }
}
