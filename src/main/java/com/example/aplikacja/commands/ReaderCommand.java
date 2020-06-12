package com.example.aplikacja.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReaderCommand {
    private Long id;
    //tutaj sobie zrób komendę do CategoryController, bo nawet nie masz jak się do niej odwołać :v
    //popraw to sobie sama, dasz radę
    private String firstName;
    private String lastName;

}
