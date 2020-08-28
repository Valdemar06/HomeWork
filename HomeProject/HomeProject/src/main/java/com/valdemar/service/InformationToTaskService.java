package com.valdemar.service;

import com.valdemar.model.InfoToTask;

import javax.sound.sampled.Line;
import java.time.LocalDateTime;
import java.util.List;

public interface InformationToTaskService {
    InfoToTask creatInfo(String textToTask,LocalDateTime time);
    InfoToTask findInfo(String textToTask);
    List<InfoToTask> findAll();
}
