package com.valdemar.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.valdemar");

       /* InformationToTaskService informationToTaskService = applicationContext.getBean(InformationToTaskService.class);
        TaskService taskService = applicationContext.getBean(TaskService.class);
        AssignService assignService = applicationContext.getBean(AssignService.class);
        ReportGeneration reportGeneration = applicationContext.getBean(ReportGeneration.class);
        ReportView reportView = applicationContext.getBean(ReportView.class);

        Main main = new Main();
        main.creatTask(taskService);
        main.createInfo(informationToTaskService);
        main.assignTasks(taskService, informationToTaskService,assignService);
        Report report = main.generateReport(reportGeneration);
        main.showReport(report, reportView);*/

    }
}
