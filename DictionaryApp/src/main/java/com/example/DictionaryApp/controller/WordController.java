package com.example.DictionaryApp.controller;

import com.example.DictionaryApp.model.dtos.wordsDto.WordDto;
import com.example.DictionaryApp.service.WordService;
import com.example.DictionaryApp.util.LoggedUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class WordController {

    private final LoggedUser loggedUser;
    private final WordService wordService;


    @ModelAttribute("wordDto")
    public WordDto postInit() {
        return new WordDto();
    }

    @GetMapping("/add")
    public ModelAndView create() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }


        return new ModelAndView("word-add");
    }

    @PostMapping("/add")
    public ModelAndView doCreate(@Valid WordDto wordDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("wordDto", wordDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordDto", bindingResult);

            return new ModelAndView("redirect:/add");
        }

        this.wordService.addWord(wordDto);

        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/words/remove/{id}")
    public String removeWord(@PathVariable("id") String id) {
        this.wordService.remove(id);
        return "redirect:/home";
    }

    @PostMapping("/words/remove-all")
    public String removeAll() {
        this.wordService.removeAll();
        return "redirect:/home";
    }
}
