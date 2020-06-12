package com.example.aplikacja.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String groupAge;
    
    @ManyToMany(mappedBy = "categories")
    private Set<Category> categories= new HashSet<>();

    public Category() {
    }
    public Category(String name) {
        this.id = id;
        this.name = name;
        this.groupAge = groupAge;
        this.categories = categories;
    }
}
