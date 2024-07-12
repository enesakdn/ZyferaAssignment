package com.zyferaassignment.zyferaassignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "grades")
public class Grade {
private int Id;
private String code;
private int value;

@ManyToOne
@JoinColumn(name = "student_id")
private Student student;
}
