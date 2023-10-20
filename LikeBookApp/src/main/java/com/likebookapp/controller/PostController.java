package com.likebookapp.controller;

import com.likebookapp.model.dtos.PostDto;
import com.likebookapp.service.PostService;
import com.likebookapp.util.LoggedUser;
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
public class PostController {

    private final LoggedUser loggedUser;
    private final PostService postService;

    @ModelAttribute("postDto")
    public PostDto postInit(){
        return new PostDto();
    }

    @GetMapping("/add")
    public ModelAndView create(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }


        return new ModelAndView("post-add");
    }

    @PostMapping("/add")
    public ModelAndView doCreate(@Valid PostDto postDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postDto", postDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postDto", bindingResult);

            return new ModelAndView("redirect:/add");
        }

        this.postService.addPost(postDto);

        return new ModelAndView("redirect:/home");
    }
}
