package com.resellerapp.controller;

import com.resellerapp.model.dtos.UserLoginDto;
import com.resellerapp.model.dtos.UserRegisterDto;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;


    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        if (loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }
    @PostMapping("/login")
    public ModelAndView login(
            @Valid UserLoginDto userLoginDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){

        if (loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userLoginDto", userLoginDto);
            redirectAttributes.addFlashAttribute("com.resellerapp.model.dtos.userLoginDto", bindingResult);

            return new ModelAndView("redirect:login");
        }
        this.userService.login(userLoginDto);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(){
        if (loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("register");
    }

    @ModelAttribute(name = "userRegisterDto")
    public UserRegisterDto init(){
        return new UserRegisterDto();
    }

    @PostMapping("register")
    public ModelAndView register(@Valid UserRegisterDto userRegisterDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if (loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("com.resellerapp.model.dtos.userRegisterDto", bindingResult);

            return new ModelAndView("redirect:register");
        }

        this.userService.register(userRegisterDto);

        return new ModelAndView("redirect:login");
    }

    @PostMapping("logout")
    public ModelAndView logout(){
        if (!loggedUser.isLogged()){
            return new ModelAndView("redirect:/login");
        }

        this.userService.logout();
        return new ModelAndView("redirect:/");
    }
}
