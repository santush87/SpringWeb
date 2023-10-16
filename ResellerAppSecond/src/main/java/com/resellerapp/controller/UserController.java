package com.resellerapp.controller;

import com.resellerapp.model.dtos.UserLoginDto;
import com.resellerapp.model.dtos.UserRegisterDto;
import com.resellerapp.service.UserService;
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
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @PostMapping("/login")
    public ModelAndView login(@Valid UserLoginDto userLoginDto){

        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register(){
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

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute("com.resellerapp.model.dtos.userRegisterDto", bindingResult);

            return new ModelAndView("redirect:register");
        }

        this.userService.register(userRegisterDto);

        return new ModelAndView("redirect:login");
    }
}
