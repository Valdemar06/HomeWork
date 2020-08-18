package com.valdemar.service;

import com.valdemar.model.InfoToTask;
import com.valdemar.model.Task;

public class AssignServiceImp implements AssignService {

    private TaskService taskService;

    public AssignServiceImp(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task assignTask(InfoToTask infoToTask, Task task) {
        task.setInformationToTask(infoToTask);
        return taskService.saveTask(task);
    }
}
