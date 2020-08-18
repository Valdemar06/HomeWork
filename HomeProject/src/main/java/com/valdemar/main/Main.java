package com.valdemar.main;

import com.valdemar.model.InfoToTask;
import com.valdemar.model.Report;
import com.valdemar.model.Task;
import com.valdemar.service.AssignService;
import com.valdemar.service.InformationToTaskService;
import com.valdemar.service.ReportGeneration;
import com.valdemar.service.TaskService;
import com.valdemar.view.ReportView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
    InformationToTaskService informationToTaskService = applicationContext.getBean(InformationToTaskService.class);
    TaskService taskService = applicationContext.getBean(TaskService.class);
    AssignService assignService = applicationContext.getBean(AssignService.class);
    ReportGeneration reportGeneration = applicationContext.getBean(ReportGeneration.class);
    ReportView reportView = applicationContext.getBean(ReportView.class);

        Main main = new Main();
        main.creatTask(taskService);
        main.createInfo(informationToTaskService);
        main.assignTasks(taskService, informationToTaskService,assignService);
        Report report = main.generateReport(reportGeneration);
        main.showReport(report, reportView);
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
