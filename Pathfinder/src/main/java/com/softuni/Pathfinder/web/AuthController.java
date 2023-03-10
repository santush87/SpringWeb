package com.softuni.Pathfinder.web;

import com.softuni.Pathfinder.domain.dtos.binding.UserLoginForm;
import com.softuni.Pathfinder.domain.dtos.binding.UserRegisterForm;
import com.softuni.Pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView,
                                    @ModelAttribute(name = "userRegisterInfo")
                                    UserRegisterForm userRegisterForm) {

        return super.view("register", modelAndView.addObject("userRegisterInfo", userRegisterForm));
    }

    @PostMapping("/register")
    public ModelAndView doRegister(ModelAndView modelAndView,
                                   @ModelAttribute(name = "userRegisterInfo") UserRegisterForm userRegisterInfo,
                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return super.view("register");
        }

        this.userService.registerUser(userRegisterInfo);

        return super.redirect("login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return super.view("login");
    }

    @PostMapping("/login")
    public ModelAndView postLogin(UserLoginForm userLoginForm
    ) {

        return this.userService.loginUser(userLoginForm).isValid()
                ? super.redirect("/")
                : super.redirect("login");

    }

    @GetMapping("/logout")
    public ModelAndView getLogout() {
        this.userService.logout();

        return super.redirect("/");
    }
}
