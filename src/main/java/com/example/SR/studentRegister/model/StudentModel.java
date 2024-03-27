package com.example.SR.studentRegister.model;

import com.example.SR.studentRegister.DTOs.StudentDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_STUDENT")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private int studentCode;
    private String name;
    private String course;
    private LocalDate birthDate;

    public StudentModel() {
    }

    public StudentModel(StudentDTO studentDTO) {
        this.studentCode = studentDTO.studentCode();
        this.name = studentDTO.name();
        this.course = studentDTO.course();
        this.birthDate= studentDTO.birthDate();
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    @Override
    public String toString() {
        return "StudentModel{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
