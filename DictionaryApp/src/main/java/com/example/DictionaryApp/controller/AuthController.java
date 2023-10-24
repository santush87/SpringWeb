package com.example.DictionaryApp.controller;

import com.example.DictionaryApp.model.dtos.UserLoginDto;
import com.example.DictionaryApp.model.dtos.UserRegisterDto;
import com.example.DictionaryApp.service.UserService;
import com.example.DictionaryApp.util.LoggedUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final LoggedUser loggedUser;


    /***    LOGIN   ***/

    /***    Model Attribute   ***/
    @ModelAttribute("userLoginDto")
    public UserLoginDto logInit(){
        return new UserLoginDto();
    }

    /***   GetMapping   ***/
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    /***   PostMapping   ***/
    @PostMapping("/login")
    public ModelAndView doLogin(@Valid UserLoginDto userLoginDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto", bindingResult);

            return new ModelAndView("redirect:login");
        }

        try {
            boolean loggedIn = this.userService.login(userLoginDto);
            if (loggedIn) {
                return new ModelAndView("redirect:home");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        return new ModelAndView("login");
    }

    /***    REGISTER   ***/

    /***    Model Attribute   ***/
    @ModelAttribute("userRegisterDto")
    public UserRegisterDto regInit(){
        return new UserRegisterDto();
    }

    /***    GetMapping   ***/
    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    /***   PostMapping   ***/
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
        } catch (IllegalArgumentException e) {
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
