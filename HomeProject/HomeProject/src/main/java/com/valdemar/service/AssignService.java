package com.valdemar.service;

import com.valdemar.model.InfoToTask;
import com.valdemar.model.Task;

public interface AssignService {
    Task assignTask(InfoToTask infoToTask, Task task);
}
