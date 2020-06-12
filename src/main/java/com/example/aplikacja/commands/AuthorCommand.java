package com.example.aplikacja.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorCommand {
    private Long id;
    private String firstName;
    private String lastName;
    private String nick;
}
