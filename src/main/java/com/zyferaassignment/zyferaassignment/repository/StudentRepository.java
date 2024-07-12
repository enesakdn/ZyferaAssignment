package com.zyferaassignment.zyferaassignment.repository;

import com.zyferaassignment.zyferaassignment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // finding students by student number
    Student findByStdNumber(String stdNumber);
}