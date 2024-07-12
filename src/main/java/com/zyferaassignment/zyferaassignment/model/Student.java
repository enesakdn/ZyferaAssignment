package com.zyferaassignment.zyferaassignment.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  Id;
    private String name;
    private String stdNumber;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Grade grade;
}
