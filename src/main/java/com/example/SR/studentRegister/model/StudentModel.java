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

    //required so it can get allStudents
    public StudentModel() {
    }

    //converts DTO to a StudentModel object
    public StudentModel(StudentDTO studentDTO) {
        this.studentCode = studentDTO.studentCode();
        this.name = studentDTO.name();
        this.course = studentDTO.course();
        this.birthDate= studentDTO.birthDate();
    }

    public int getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(int studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
