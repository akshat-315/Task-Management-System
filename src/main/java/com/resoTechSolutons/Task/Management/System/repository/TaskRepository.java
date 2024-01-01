package com.resoTechSolutons.Task.Management.System.repository;

import com.resoTechSolutons.Task.Management.System.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
