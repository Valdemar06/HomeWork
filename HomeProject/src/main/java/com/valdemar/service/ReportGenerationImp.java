package com.valdemar.service;

import com.valdemar.model.InfoToTask;
import com.valdemar.model.Report;
import com.valdemar.model.Task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGenerationImp implements ReportGeneration {
    private TaskService taskService;
    private InformationToTaskService informationToTaskService;

    public ReportGenerationImp(TaskService taskService, InformationToTaskService informationToTaskService) {
        this.taskService = taskService;
        this.informationToTaskService = informationToTaskService;
    }

    @Override
    public Report generateReport() {
        Report report = new Report();
        for (InfoToTask info :informationToTaskService.findAll()) {
                List<Task> infoTask = taskService.findTaskAssignedToInfo(info);
                totalDuration(infoTask);
                nameTasks(infoTask);
                Report.ReportEntry entry = new Report.ReportEntry(info, totalDuration(infoTask),nameTasks(infoTask));
                report.addEntry(entry);
        }
        return report;
    }
    private Duration totalDuration(List<Task> infoTask){
        return infoTask.stream().map(task -> Duration.between(task.getFrom(),task.getEnd()))
                .reduce(Duration::plus)
                .orElse(Duration.ZERO);
    }

    private String nameTasks(List<Task> nameTask){
        return nameTask.stream().map(name-> name.getTaskName().toUpperCase()).collect(Collectors.joining());
    }

}
