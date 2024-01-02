package com.resoTechSolutons.Task.Management.System.controller;

import com.resoTechSolutons.Task.Management.System.dto.TaskDto;
import com.resoTechSolutons.Task.Management.System.service.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

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

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        TaskDto taskDto = taskService.getTaskById(id);
        model.addAttribute("taskDto", taskDto);
        return "update-task";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute TaskDto taskDto, RedirectAttributes redirectAttributes){
        taskService.updateTask(id, taskDto);
        redirectAttributes.addFlashAttribute("message", "Task updated successfully!");
        return "redirect:/tasks/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/tasks/list";
    }
}
