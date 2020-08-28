package com.valdemar.repository;

import com.valdemar.model.InfoToTask;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryInformationRepository implements InformationRepository {

    private Map<String, InfoToTask> infoToTaskMap = new HashMap<>();
    @Override
    public InfoToTask save(InfoToTask infoToTask) {
        infoToTaskMap.put(infoToTask.getId(), infoToTask);
        return infoToTask;
    }

    @Override
    public InfoToTask find(String id) {
        return infoToTaskMap.get(id);
    }

    @Override
    public List<InfoToTask> findAll() {
        return infoToTaskMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public InfoToTask delete(String id) {
        return infoToTaskMap.remove(id);
    }
}
