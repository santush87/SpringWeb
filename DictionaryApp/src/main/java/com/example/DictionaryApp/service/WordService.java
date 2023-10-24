package com.example.DictionaryApp.service;

import com.example.DictionaryApp.model.dtos.wordsDto.WordDto;
import com.example.DictionaryApp.model.dtos.wordsDto.WordToShow;
import com.example.DictionaryApp.model.dtos.wordsDto.WordsViewModel;
import com.example.DictionaryApp.model.entity.LanguageEntity;
import com.example.DictionaryApp.model.entity.UserEntity;
import com.example.DictionaryApp.model.entity.WordEntity;
import com.example.DictionaryApp.repo.LanguageRepository;
import com.example.DictionaryApp.repo.UserRepository;
import com.example.DictionaryApp.repo.WordRepository;
import com.example.DictionaryApp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;
    public void addWord(WordDto wordDto) {
        UserEntity user = this.userRepository.findByUsername(this.loggedUser.getUsername());
        LanguageEntity language = this.languageRepository.findByName(wordDto.getLanguage());

        if (language != null){
            WordEntity word = this.modelMapper.map(wordDto, WordEntity.class);
            word.setAddedBy(user);
            word.setLanguage(language);

            this.wordRepository.save(word);
        }
    }


    public WordsViewModel getHomeViewData(String username) {
        List<WordEntity> allWords = this.wordRepository.findAll();

        List<WordToShow> german = new ArrayList<>();
        List<WordToShow> french = new ArrayList<>();
        List<WordToShow> spanish = new ArrayList<>();
        List<WordToShow> italian = new ArrayList<>();

        for (WordEntity word : allWords) {
            WordToShow wordToAdd = this.modelMapper.map(word, WordToShow.class);
            switch (word.getLanguage().getName()){
                case GERMAN -> {
                    if (word.getAddedBy().getUsername().equals(username)){
                        wordToAdd.setUsername("admin");
                    }else {
                        wordToAdd.setUsername(word.getAddedBy().getUsername());
                    }
                    german.add(wordToAdd);
                }
                case SPANISH -> {
                    if (word.getAddedBy().getUsername().equals(username)){
                        wordToAdd.setUsername("admin");
                    }else {
                        wordToAdd.setUsername(word.getAddedBy().getUsername());
                    }
                    spanish.add(wordToAdd);
                }
                case ITALIAN -> {
                    if (word.getAddedBy().getUsername().equals(username)){
                        wordToAdd.setUsername("admin");
                    }else {
                        wordToAdd.setUsername(word.getAddedBy().getUsername());
                    }
                    italian.add(wordToAdd);
                }
                case FRENCH -> {
                    if (word.getAddedBy().getUsername().equals(username)){
                        wordToAdd.setUsername("admin");
                    }else {
                        wordToAdd.setUsername(word.getAddedBy().getUsername());
                    }
                    french.add(wordToAdd);
                }
            }
        }
        return new WordsViewModel(german, french, spanish, italian);
    }

    public void remove(String id) {
        this.wordRepository.deleteById(id);
    }

    public void removeAll() {
        this.wordRepository.deleteAll();
    }
}
