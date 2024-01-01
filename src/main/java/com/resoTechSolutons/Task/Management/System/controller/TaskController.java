package com.resoTechSolutons.Task.Management.System.controller;

import com.resoTechSolutons.Task.Management.System.dto.TaskDto;
import com.resoTechSolutons.Task.Management.System.service.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public String createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);

    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id,@RequestBody TaskDto taskDto){
        return taskService.updateTask(id, taskDto);
    }
}
