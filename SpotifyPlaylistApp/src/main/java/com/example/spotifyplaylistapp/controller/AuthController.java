package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dtos.UserLoginDto;
import com.example.spotifyplaylistapp.model.dtos.UserRegisterDto;
import com.example.spotifyplaylistapp.service.UserService;
import com.example.spotifyplaylistapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    /***    LOGIN   ***/

    /***    MODEL ATTRIBUTE   ***/
    @ModelAttribute("userLoginDto")
    public UserLoginDto logInit(){
        return new UserLoginDto();
    }
    @GetMapping("/login")
    public ModelAndView login(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    /***    REGISTER   ***/

    /***    MODEL ATTRIBUTE   ***/
    @ModelAttribute("userRegisterDto")
    public UserRegisterDto regInit(){
        return new UserRegisterDto();
    }
    @GetMapping("/register")
    public ModelAndView register(){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@Valid UserRegisterDto userRegisterDto,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);

            return new ModelAndView("redirect:register");
        }

        try {
            boolean registered = this.userService.register(userRegisterDto);
            if (registered) {
                return new ModelAndView("redirect:home");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return new ModelAndView("register");
    }

    /***    LOGOUT   ***/
    @PostMapping("/logout")
    public ModelAndView logout(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
