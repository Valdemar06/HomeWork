package com.valdemar.FirstProject.repository;

import com.valdemar.FirstProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
