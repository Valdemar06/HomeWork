package com.valdemar.view;

import com.valdemar.model.Report;

public class ReportToConsoleImp implements  ReportView{
    @Override
    public void showReport(Report report) {
        System.out.println("***************************************");
        for (Report.ReportEntry reportEntry: report.getEntries()) {
            System.out.println(String.format("%s\t%s\t%s",
                    reportEntry.getTaskName(),
                    reportEntry.getInfoToTask().getTextToTask().toLowerCase(),
                    reportEntry.getDuration().toHours()));

        }
        System.out.println("***************************************");
    }

}
