package com.valdemar.FirstProject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_info")
    private String taskInfo;
    @Column(name = "task_time")
    private String taskTime;
}
