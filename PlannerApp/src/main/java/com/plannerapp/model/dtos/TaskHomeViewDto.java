package com.plannerapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TaskHomeViewDto {

    private List<TaskDto> myTasks;
    private List<TaskDto> availableTasks;

    public TaskHomeViewDto() {
        this.myTasks = new ArrayList<>();
        this.availableTasks = new ArrayList<>();
    }
}
