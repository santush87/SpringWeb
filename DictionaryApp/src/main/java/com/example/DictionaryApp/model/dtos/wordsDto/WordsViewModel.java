package com.example.DictionaryApp.model.dtos.wordsDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordsViewModel {

    private List<WordToShow> germanWords;
    private List<WordToShow> frenchWords;
    private List<WordToShow> spanishWords;
    private List<WordToShow> italianWords;

    private int deCount;
    private int frCount;
    private int esCount;
    private int itCount;
    private int totalCount;

    public WordsViewModel(List<WordToShow> germanWords, List<WordToShow> frenchWords, List<WordToShow> spanishWords, List<WordToShow> italianWords) {
        this.germanWords = germanWords;
        this.frenchWords = frenchWords;
        this.spanishWords = spanishWords;
        this.italianWords = italianWords;
        this.deCount = germanWords.size();
        this.esCount = spanishWords.size();
        this.frCount = frenchWords.size();
        this.itCount = italianWords.size();
        this.totalCount = this.deCount +
                this.esCount +
                this.itCount +
                this.frCount;
    }
}
