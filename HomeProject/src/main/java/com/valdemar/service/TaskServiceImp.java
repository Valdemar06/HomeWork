package com.valdemar.service;

import com.valdemar.model.InfoToTask;
import com.valdemar.model.Task;
import com.valdemar.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImp implements  TaskService {
    private IdGenerator idGenerator;
    private TaskRepository taskRepository;

    public TaskServiceImp(IdGenerator idGenerator, TaskRepository taskRepository) {
        this.idGenerator = idGenerator;
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(String nameTask, LocalDateTime from, LocalDateTime end) {
        String id = idGenerator.generation();
        Task task = new Task(id,nameTask,from,end);
        saveTask(task);
        return task;
    }


    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findTask(String nameTask) {
        List<Task> all = taskRepository.findAll();
        return all.stream().filter(task -> task.getTaskName().equals(nameTask)).findFirst().get();
    }
    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findTaskAssignedToInfo(InfoToTask infoToTask) {
        List<Task> tasks = findAllTasks();
        return tasks.stream().filter(task -> task.getInfoToTask().equals(infoToTask))
                .collect(Collectors.toList());
    }

}
