package com.zyferaassignment.zyferaassignment.repository;

import com.zyferaassignment.zyferaassignment.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
}