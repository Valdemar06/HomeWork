package com.valdemar.service;

import com.valdemar.model.InfoToTask;

import com.valdemar.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class InformationToTaskServiceImp implements InformationToTaskService {
    private IdGenerator idGenerator;
    private InformationRepository informationRepository;

@Autowired
    public InformationToTaskServiceImp(IdGenerator idGenerator, InformationRepository informationRepository) {
        this.idGenerator = idGenerator;
        this.informationRepository = informationRepository;

    }

    @Override
    public InfoToTask creatInfo(String textToTask ,LocalDateTime time) {
        String id = idGenerator.generation();

        InfoToTask newInfo = new InfoToTask(id,time,textToTask);
        informationRepository.save(newInfo);
        return newInfo;
    }

    @Override
    public InfoToTask findInfo(String textToTask) {
        List<InfoToTask> infos = informationRepository.findAll();
        return infos.stream().filter(info -> info.getTextToTask().equals(textToTask)).findFirst().get();
    }


    @Override
    public List<InfoToTask> findAll() {
        return informationRepository.findAll();
    }
}
