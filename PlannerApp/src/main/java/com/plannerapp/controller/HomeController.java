package com.plannerapp.controller;

import com.plannerapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoggedUser loggedUser;

    @GetMapping("/")
    public String index(){
        if (loggedUser.isLogged()){
            return "redirect:home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(){
        if (!loggedUser.isLogged()){
            return "redirect:/";
        }
        return "home";
    }
}
