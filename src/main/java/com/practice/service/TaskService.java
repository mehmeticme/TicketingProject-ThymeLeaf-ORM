package com.practice.service;

import com.practice.dto.TaskDTO;
import com.practice.entity.Task;

import java.util.List;

public interface TaskService {

    TaskDTO findById(Long id);
    List<TaskDTO> listAllTasks();
    Task save(TaskDTO dto);
    void update(TaskDTO dto);
    void delete(long id);

}