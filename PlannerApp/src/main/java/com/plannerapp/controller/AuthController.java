package com.plannerapp.controller;

import com.plannerapp.model.dtos.UserLoginDto;
import com.plannerapp.model.dtos.UserRegisterDto;
import com.plannerapp.service.UserService;
import com.plannerapp.util.LoggedUser;
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
public class AuthController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto initRegisterForm() {
        return new UserRegisterDto();
    }

    @GetMapping("/register")
    public String register() {
        if (loggedUser.isLogged()) {
            return"redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid UserRegisterDto userRegisterDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return"redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDto", bindingResult);

            return "redirect:register";
        }
        try {
            boolean registered = this.userService.register(userRegisterDto);
            if (registered) {
                return "redirect:home";
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:register";
    }

    @ModelAttribute("userLoginDto")
    public UserLoginDto initLoginForm() {
        return new UserLoginDto();
    }

    @GetMapping("/login")
    public String login() {
        if (loggedUser.isLogged()) {
            return"redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid UserLoginDto userLoginDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return"redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDto", bindingResult);

            return "redirect:login";
        }

        try {
            boolean loggedIn = this.userService.login(userLoginDto);
            if (loggedIn) {
                return "redirect:home";
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
            return "redirect:login";
    }
}
