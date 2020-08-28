package com.valdemar.repository;

import com.valdemar.model.InfoToTask;

import java.util.List;

public interface InformationRepository {

    InfoToTask save(InfoToTask infoToTask);
    InfoToTask find(String id);
    List<InfoToTask> findAll();
    InfoToTask delete(String id);
}
