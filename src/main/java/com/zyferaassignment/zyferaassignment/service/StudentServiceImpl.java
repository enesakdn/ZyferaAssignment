package com.zyferaassignment.zyferaassignment.service;

import com.zyferaassignment.zyferaassignment.model.Grade;
import com.zyferaassignment.zyferaassignment.model.Student;
import com.zyferaassignment.zyferaassignment.repository.GradeRepository;
import com.zyferaassignment.zyferaassignment.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    @Transactional
    public Student createStudent(Student student) {
        calculateAndSetAverageGrades(student);
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(String stdNumber, Student updatedStudent) {
        Student existingStudent = studentRepository.findByStdNumber(stdNumber);
        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setGrades(updatedStudent.getGrades());
            calculateAndSetAverageGrades(existingStudent);
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    private void calculateAndSetAverageGrades(Student student) {
        List<Grade> grades = student.getGrades();
        if (grades != null && !grades.isEmpty()) {
            Map<String, Double> averageGrades = grades.stream()
                    .collect(Collectors.groupingBy(Grade::getCode, Collectors.averagingDouble(Grade::getValue)));

            List<Grade> updatedGrades = new ArrayList<>();

            averageGrades.forEach((code, avg) -> {
                updatedGrades.add(new Grade(code, (int) Math.round(avg), student));
            });
            student.setGrades(updatedGrades);
        }
    }
};
