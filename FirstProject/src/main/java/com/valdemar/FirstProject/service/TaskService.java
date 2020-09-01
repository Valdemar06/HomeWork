package com.valdemar.FirstProject.service;

import com.valdemar.FirstProject.model.Task;

import java.util.List;

public interface TaskService {
    Task findById(Long id);
    List<Task> findAll();
    Task saveTask(Task task);
    void deleteTask(Long id);
}
