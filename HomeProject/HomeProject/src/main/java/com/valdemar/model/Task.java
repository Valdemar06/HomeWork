package com.valdemar.model;

import java.time.LocalDateTime;

public class Task {
    private String id;
    private String taskName;
    private LocalDateTime from;
    private LocalDateTime end;
    private InfoToTask infoToTask;

    public Task(String id,String taskName, LocalDateTime from, LocalDateTime end) {
        this.id = id;
        this.taskName = taskName;
        this.from = from;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public InfoToTask getInfoToTask() {
        return infoToTask;
    }

    public void setInformationToTask(InfoToTask infoToTask) {
        this.infoToTask = infoToTask;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
