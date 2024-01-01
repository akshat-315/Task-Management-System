package com.resoTechSolutons.Task.Management.System.service.serviceImpl;

import com.resoTechSolutons.Task.Management.System.dto.TaskDto;
import com.resoTechSolutons.Task.Management.System.entity.TaskEntity;
import com.resoTechSolutons.Task.Management.System.repository.TaskRepository;
import com.resoTechSolutons.Task.Management.System.service.services.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl() {
        super();
    }

    @Override
    public String createTask(TaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity();
        BeanUtils.copyProperties(taskDto, taskEntity);
        taskRepository.save(taskEntity);
        return "Task Assigned Successfully!";
    }

    @Override
    public String updateTask(Long id, TaskDto taskDto) {
        TaskEntity existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask != null) {
            existingTask.setTitle(taskDto.getTitle());
            existingTask.setDescription(taskDto.getDescription());
            existingTask.setStatus(taskDto.getStatus());
            existingTask.setDueDate(taskDto.getDueDate());
            taskRepository.save(existingTask);
            return "Task Updated Successfully!";
        }
        return "Could not find any task.";
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        List<TaskDto> taskDtos = taskEntities
                .stream()
                .map(task -> new TaskDto(
                        task.getTitle(),
                        task.getDescription(),
                        task.getDueDate(),
                        task.getStatus()))
                .collect(Collectors.toList());
        return taskDtos;
    }

    @Override
    public String deleteTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        taskRepository.delete(taskEntity);
        return "Task Deleted Successfully!";
    }
}
