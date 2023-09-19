package com.aleksandrov.battleShips.controllers;

import com.aleksandrov.battleShips.models.dtos.UserLoginDto;
import com.aleksandrov.battleShips.models.dtos.UserRegistrationDto;
import com.aleksandrov.battleShips.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registrationDto")
    public UserRegistrationDto initRegistrationDTO() {
        return new UserRegistrationDto();
    }


    @GetMapping("/register")
    public String register() {
        if (this.authService.isLoggedIn()){
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDto registrationDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (this.authService.isLoggedIn()){
            return "redirect:/home";
        }

        if (bindingResult.hasErrors() || !this.authService.register(registrationDto)) {
            redirectAttributes.addFlashAttribute(
                    "registrationDto",
                    registrationDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDto",
                    bindingResult);

            return "redirect:register";
        }

        return "redirect:login";
    }

    @ModelAttribute("loginDto")
    public UserLoginDto initLoginDTO() {
        return new UserLoginDto();
    }
    @GetMapping("/login")
    public String login() {
        if (this.authService.isLoggedIn()){
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDto loginDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.authService.isLoggedIn()){
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDto",
                    bindingResult);

            System.out.println("With errors: "+loginDto);

            return "redirect:/login";
        }

        if (!this.authService.login(loginDto)){
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout(){
        this.authService.logout();

        return "redirect:/";
    }
}
