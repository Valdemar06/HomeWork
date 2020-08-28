package com.valdemar.model;

import java.time.LocalDateTime;

public class InfoToTask {
    private String id;
    private LocalDateTime add;
    private String textToTask;

    public InfoToTask(String id, LocalDateTime add,String textToTask) {
        this.id = id;
        this.add = add;
        this.textToTask = textToTask;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getAdd() {
        return add;
    }

    public void setAdd(LocalDateTime add) {
        this.add = add;
    }

    public String getTextToTask() {
        return textToTask;
    }

    public void setTextToTask(String textToTask) {
        this.textToTask = textToTask;
    }

}
