package com.plannerapp.service;

import com.plannerapp.model.dtos.TaskDto;
import com.plannerapp.model.dtos.TaskHomeViewDto;
import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    public TaskHomeViewDto allTasksForHomePage() {
        List<TaskEntity> allTasks = this.taskRepository.findAll();

        List<TaskDto> myTasks = new ArrayList<>();
        List<TaskDto> availableTasks = new ArrayList<>();

        String loggedUsername = this.loggedUser.getUsername();

        for (TaskEntity task : allTasks) {
            if (task.getAssignee().getUsername().equals(loggedUsername)) {
                TaskDto taskToAdd = this.modelMapper.map(task, TaskDto.class);
//                taskToAdd.setLoggedUsername(loggedUsername);
                taskToAdd.setPriority(task.getPriority().getName());
                myTasks.add(taskToAdd);
            } else {
                TaskDto avTaskToAdd = this.modelMapper.map(task, TaskDto.class);
//                avTaskToAdd.setTotalUnassignedTasks(avTaskToAdd.getTotalUnassignedTasks() + 1);
                avTaskToAdd.setPriority(task.getPriority().getName());

                availableTasks.add(avTaskToAdd);
            }
        }
        return new TaskHomeViewDto(myTasks, availableTasks);
    }

    public void createTask(TaskDto taskDto) {
        String loggedUsername = this.loggedUser.getUsername();
        Optional<UserEntity> user = this.userRepository.findByUsername(loggedUsername);
        PriorityEntity priority = this.priorityRepository.findByName(taskDto.getPriority());
        if (priority != null) {
            TaskEntity task = this.modelMapper.map(taskDto, TaskEntity.class);
            task.setPriority(priority);
            task.setAssignee(user.get());
            this.taskRepository.save(task);
        }
    }

    public void remove(UUID id) {
        this.taskRepository.deleteById(id);
    }

    public void assign(UUID id, String username) {
        Optional<TaskEntity> optTask = this.taskRepository.findById(id);
        if (optTask.isPresent()) {
            if (username == null) {
                optTask.get().setAssignee(null);
            } else {
                Optional<UserEntity> user = this.userRepository.findByUsername(username);
                optTask.get().setAssignee(user.get());
            }

            this.taskRepository.save(optTask.get());
        }
    }

    public TaskHomeViewDto getHomeViewData(String username) {
        Optional<UserEntity> optUser = this.userRepository.findByUsername(username);
        UserEntity user = optUser.get();

        List<TaskEntity> assigneeTasks = this.taskRepository.findByAssignee(user);
        List<TaskDto> assigneeTasksDto = converterToDto(assigneeTasks, modelMapper);

        List<TaskEntity> availableTasks = this.taskRepository.findByAssigneeNot(user);
        List<TaskDto> availableTasksDto = converterToDto(availableTasks, modelMapper);

        return new TaskHomeViewDto(assigneeTasksDto, availableTasksDto);
    }

    private static List<TaskDto> converterToDto(List<TaskEntity> tasks, ModelMapper modelMapper) {
        List<TaskDto> assigneeTasksDto = new ArrayList<>();

        for (TaskEntity task : tasks) {
            TaskDto taskDto = modelMapper.map(task, TaskDto.class);
            taskDto.setPriority(task.getPriority().getName());
            assigneeTasksDto.add(taskDto);
        }
        return assigneeTasksDto;
    }
}
