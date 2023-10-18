package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dtos.SongHomeView;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoggedUser loggedUser;
    private final SongService songService;
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

        SongHomeView viewDto =
                this.songService.getHomeViewData(this.loggedUser.getUsername());

        return new ModelAndView("home", "songs", viewDto);
    }
}
