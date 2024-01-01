package com.resoTechSolutons.Task.Management.System.service.services;

import com.resoTechSolutons.Task.Management.System.dto.TaskDto;

import java.util.List;

public interface TaskService {
    public String createTask(TaskDto taskDto);
    public String updateTask(Long id, TaskDto taskDto);
    public List<TaskDto> getAllTasks();
    public String deleteTask(Long Id);
}
