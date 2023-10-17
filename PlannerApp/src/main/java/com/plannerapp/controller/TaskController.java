package com.plannerapp.controller;

import com.plannerapp.model.dtos.TaskDto;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final LoggedUser loggedUser;

    @ModelAttribute("taskDto")
    public TaskDto initTask() {
        return new TaskDto();
    }

    @GetMapping("/add")
    public String addTask() {
        return "task-add";
    }

    @PostMapping("/add")
    public String addTask(@Valid TaskDto taskDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskDto", taskDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskDto", bindingResult);

            return "redirect:/tasks/add";
        }

        this.taskService.createTask(taskDto);
        return "redirect:/home";
    }

    @PostMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") UUID id) {
        this.taskService.remove(id);
        return "redirect:/home";
    }

    @PostMapping("/return/{id}")
    public String returnTask(@PathVariable("id") UUID id) {
        this.taskService.assign(id, null);
        return "redirect:/home";
    }

    @PostMapping("/assign/{id}")
    public String assign(@PathVariable("id") UUID id) {
        this.taskService.assign(id, this.loggedUser.getUsername());
        return "redirect:/home";
    }

}
