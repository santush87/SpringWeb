package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dtos.SongDto;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SongController {

    private final LoggedUser loggedUser;
    private final SongService songService;

    @ModelAttribute("songDto")
    public SongDto songInit(){
        return new SongDto();
    }

    @GetMapping("/add")
    public ModelAndView add(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("song-add");
    }

    @PostMapping("/add")
    public ModelAndView addSong(@Valid SongDto songDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songDto", songDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songDto", bindingResult);

            return new ModelAndView("redirect:/add");
        }

        this.songService.addSong(songDto);

        return new ModelAndView("redirect:/home");
    }
}
