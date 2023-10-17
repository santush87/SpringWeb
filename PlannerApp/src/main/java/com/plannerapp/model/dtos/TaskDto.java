package com.plannerapp.model.dtos;

import com.plannerapp.annotation.StringDateInFuture;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.enums.PriorityName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private UUID id;

    private PriorityName priority;

    private String dueDate;

    private String description;

//    public TaskDto createFromTask(TaskEntity task) {
//        TaskDto taskDto = new TaskDto();
//
//        taskDto.setDescription(task.getDescription());
//        taskDto.setPriority(task.getPriority().getName());
//        taskDto.setDueDate(task.getDueDate().toString());
//
//        return taskDto;
//    }
}
