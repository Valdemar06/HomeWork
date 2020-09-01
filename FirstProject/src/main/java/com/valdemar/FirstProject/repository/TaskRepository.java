package com.valdemar.FirstProject.repository;

import com.valdemar.FirstProject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
