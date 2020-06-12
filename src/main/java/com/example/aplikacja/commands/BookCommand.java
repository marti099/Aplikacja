package com.example.aplikacja.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookCommand {
    private Long id;
    private String title;
    private String year;
    private String publisher;
}
