package com.example.DictionaryApp.model.dtos.wordsDto;

import com.example.DictionaryApp.annotation.StringDateInPastOrPresent;
import com.example.DictionaryApp.model.enums.LanguageName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDto {

    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;

    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 40 characters!")
    private String translation;

    @Size(min = 2, max = 200)
    private String example;

    @StringDateInPastOrPresent(message = "The input must be in the past or present!")
    private String inputDate;
    @NotNull(message = "You must select a language!")
    private LanguageName language;

}
