package com.valdemar.service;

import com.valdemar.model.InfoToTask;
import com.valdemar.model.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
     Task createTask(String nameTask, LocalDateTime from, LocalDateTime end);
     Task saveTask(Task task);
     Task findTask(String nameTask);
     List<Task> findAllTasks();
     List<Task> findTaskAssignedToInfo(InfoToTask infoToTask);
}
