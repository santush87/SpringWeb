package com.plannerapp.controller;

import com.plannerapp.model.dtos.TaskHomeViewDto;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoggedUser loggedUser;
    private final TaskService taskService;

    @GetMapping("/")
    public String index() {
        if (loggedUser.isLogged()) {
            return "redirect:home";
        }
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView home() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

//        ModelAndView modelAndView = new ModelAndView("home");
//        TaskHomeViewDto allTasksForHomePage = this.taskService.allTasksForHomePage();
//
//        modelAndView.addObject("taskHomeDto", allTasksForHomePage);
        TaskHomeViewDto viewDto =
                this.taskService.getHomeViewData(this.loggedUser.getUsername());

        return new ModelAndView("home", "tasks", viewDto);
    }
}
