package com.valdemar.model;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Report {
    List<ReportEntry> entries;

    public Report() {
        this.entries = new ArrayList<>();
    }

    public List<ReportEntry> getEntries() {
        return entries;
    }

    public void addEntry(ReportEntry reportEntry){
        entries.add(reportEntry);
    }

    public void setEntries(List<ReportEntry> entries) {
        this.entries = entries;
    }

    public static class ReportEntry{
        private InfoToTask infoToTask;
        private Duration duration;
        private String taskName;


        public ReportEntry(InfoToTask infoToTask, Duration duration, String taskName) {
            this.infoToTask = infoToTask;
            this.duration = duration;
            this.taskName = taskName;

        }

        public InfoToTask getInfoToTask() {
            return infoToTask;
        }

        public Duration getDuration() {
            return duration;
        }

        public String getTaskName() { return taskName; }

    }
}
