package com.resoTechSolutons.Task.Management.System.controller;

import com.resoTechSolutons.Task.Management.System.dto.TaskDto;
import com.resoTechSolutons.Task.Management.System.service.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/list")
    public String displayTasks(Model model){
        List<TaskDto> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute TaskDto taskDto){
        taskService.createTask(taskDto);
        return "redirect:/tasks/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("taskDto", new TaskDto());
        return "create-task";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        TaskDto taskDto = taskService.getTaskById(id);
        logger.info("Received update request for task with ID: {}", taskDto.getDueDate());
        model.addAttribute("taskDto", taskDto);
        return "edit-task";
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute TaskDto taskDto) {
        taskService.updateTask(id, taskDto);
        logger.info("Received update request for task with ID: {}", id);
        logger.info("Received task data: {}", taskDto);
        return "redirect:/tasks/list";
    }
}
