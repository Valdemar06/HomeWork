package com.valdemar;


import com.valdemar.model.InfoToTask;
import com.valdemar.model.Report;
import com.valdemar.model.Task;
import com.valdemar.service.*;
import com.valdemar.view.ReportView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class Demo {
    private AssignService assignService;
    private InformationToTaskService informationToTaskService;
    private TaskService taskService;
    private ReportGeneration reportGeneration;
    private ReportView reportView;
@Autowired
    public Demo(AssignService assignService, InformationToTaskService informationToTaskService, TaskService taskService,
                ReportGeneration reportGeneration, ReportView reportView) {
        this.assignService = assignService;
        this.informationToTaskService = informationToTaskService;
        this.taskService = taskService;
        this.reportGeneration = reportGeneration;
        this.reportView = reportView;
    }
@PostConstruct
    public void demoData(){
        creatTask(taskService);
        createInfo(informationToTaskService);
        assignTasks(taskService, informationToTaskService,assignService);
        Report report = generateReport(reportGeneration);
        showReport(report, reportView);
    }

    private Report generateReport(ReportGeneration reportGeneration){
        return reportGeneration.generateReport();
    }
    private void showReport(Report report, ReportView reportView){
        reportView.showReport(report);
    }
    private void assignTasks(TaskService taskService, InformationToTaskService informationToTaskService, AssignService assignService){
        List<Task> tasks = taskService.findAllTasks();
        List<InfoToTask> infoToTasks = informationToTaskService.findAll();
        assignService.assignTask(infoToTasks.get(0), tasks.get(0));
        assignService.assignTask(infoToTasks.get(1), tasks.get(1));
        assignService.assignTask(infoToTasks.get(2), tasks.get(2));
        assignService.assignTask(infoToTasks.get(3), tasks.get(3));
        assignService.assignTask(infoToTasks.get(4), tasks.get(4));
    }
    private void createInfo(InformationToTaskService informationToTaskService){
        informationToTaskService.creatInfo("Some TasK",
                LocalDateTime.of(2020,8,18,14,35));
        informationToTaskService.creatInfo("Some Time",
                LocalDateTime.of(2020,8,18,14,35));
        informationToTaskService.creatInfo("Some Clock",
                LocalDateTime.of(2020,8,18,14,35));
        informationToTaskService.creatInfo("Some Vova",
                LocalDateTime.of(2020,8,18,14,35));
        informationToTaskService.creatInfo("Some Friend",
                LocalDateTime.of(2020,8,18,14,35));
    }
    private void creatTask(TaskService taskService){
        taskService.createTask("Im working",
                LocalDateTime.of(2020,8,18,14,35),
                LocalDateTime.of(2020,8,18,16,35));
        taskService.createTask("What are you doing",
                LocalDateTime.of(2020,8,18,16,35),
                LocalDateTime.of(2020,8,18,17,35));
        taskService.createTask("Maybe stop",
                LocalDateTime.of(2020,8,18,18,35),
                LocalDateTime.of(2020,8,18,19,35));
        taskService.createTask("Go to Sleep",
                LocalDateTime.of(2020,8,18,20,35),
                LocalDateTime.of(2020,8,18,21,35));
        taskService.createTask("Please stop ",
                LocalDateTime.of(2020,8,18,22,35),
                LocalDateTime.of(2020,8,18,23,35));
    }
}
