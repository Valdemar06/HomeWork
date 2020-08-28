package com.valdemar.repository;

import com.valdemar.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    Task find(String id);
    List<Task> findAll();
    Task delete(String id);
}
