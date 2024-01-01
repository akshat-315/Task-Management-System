package com.resoTechSolutons.Task.Management.System.dto;

import com.resoTechSolutons.Task.Management.System.Enum.TaskStatus;
import java.time.LocalDate;

public class TaskDto {
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;

    public TaskDto() {
    }

    public TaskDto(String title, String description, LocalDate dueDate, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }



}
