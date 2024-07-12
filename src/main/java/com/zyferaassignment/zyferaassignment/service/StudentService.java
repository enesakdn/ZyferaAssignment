package com.zyferaassignment.zyferaassignment.service;

import com.zyferaassignment.zyferaassignment.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student updateStudent(String stdNumber, Student updatedStudent);
}