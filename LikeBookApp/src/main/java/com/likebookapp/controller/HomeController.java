package com.likebookapp.controller;

import com.likebookapp.model.dtos.PostHomeView;
import com.likebookapp.service.PostService;
import com.likebookapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoggedUser loggedUser;
    private final PostService postService;



    @GetMapping("/")
    public ModelAndView index(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        PostHomeView viewDto = this.postService.getHomeViewData(this.loggedUser.getUsername());

        return new ModelAndView("home", "posts", viewDto);
    }
}
