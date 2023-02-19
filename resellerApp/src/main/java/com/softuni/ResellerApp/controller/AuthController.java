package com.softuni.ResellerApp.controller;

import com.softuni.ResellerApp.model.dtos.UserLoginModel;
import com.softuni.ResellerApp.model.dtos.UserRegisterModel;
import com.softuni.ResellerApp.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute(name = "userRegisterModel")
    public UserRegisterModel userRegisterModel() {
        return new UserRegisterModel();
    }

    @ModelAttribute(name = "userLoginModel")
    public UserLoginModel userLoginModel() {
        return new UserLoginModel();
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }


    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterModel")
                               UserRegisterModel userRegisterModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterModel",
                            bindingResult);

            return "redirect:register";
        }
        if (!this.authService.registerUser(userRegisterModel) ||
                !userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterModel", userRegisterModel);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/register";
        }

        this.authService.registerUser(userRegisterModel);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String getLogout() {
        this.authService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginModel")
                            UserLoginModel userLoginModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel",
                            bindingResult);

            return "redirect:login";
        }

        if (!this.authService.loginUser(userLoginModel)) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }

        this.authService.loginUser(userLoginModel);

        return "redirect:/home";
    }
}
