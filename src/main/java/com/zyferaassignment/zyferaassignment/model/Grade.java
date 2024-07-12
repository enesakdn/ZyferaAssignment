package com.zyferaassignment.zyferaassignment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String code;
private int value;
@ManyToOne
@JoinColumn(name = "student_id")
private Student student;

    public Grade(String code, int value, Student student) {
        this.code = code;
        this.value = value;
        this.student = student;
    };
}
