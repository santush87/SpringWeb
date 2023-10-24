package com.example.DictionaryApp.model.dtos.wordsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordToShow {

    private String id;
    private String term;
    private String translation;
    private String example;
    private String inputDate;
    private String username;

}
