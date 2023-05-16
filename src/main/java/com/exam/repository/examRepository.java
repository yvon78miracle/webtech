package com.exam.repository;

import com.exam.model.exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface examRepository extends JpaRepository<exam,Integer> {
}
