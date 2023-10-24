package com.example.DictionaryApp.controller;

import com.example.DictionaryApp.model.dtos.wordsDto.WordsViewModel;
import com.example.DictionaryApp.service.WordService;
import com.example.DictionaryApp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;

    @GetMapping("/")
    public ModelAndView index(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:home");
        }
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        WordsViewModel viewDto =
                this.wordService.getHomeViewData(this.loggedUser.getUsername());

        return new ModelAndView("home", "words", viewDto);
    }
}
