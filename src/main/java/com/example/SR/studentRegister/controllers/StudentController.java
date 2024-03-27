package com.example.SR.studentRegister.controllers;

import com.example.SR.studentRegister.DTOs.StudentDTO;
import com.example.SR.studentRegister.model.StudentModel;
import com.example.SR.studentRegister.repositories.StudentRegisterRepository;
import com.example.SR.studentRegister.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @Autowired
    StudentRegisterRepository studentRegisterRepository;

    @PostMapping("/postStudent")
    public ResponseEntity<StudentModel> postStudent(@RequestBody StudentDTO studentDTO){
        StudentModel studentRegister = new StudentModel(studentDTO);
        studentRegisterRepository.save(studentRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/getStudent")
    public ResponseEntity getAllStudents(){
        List<StudentModel> allStudents = studentRegisterRepository.findAll();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping(path = "/student/{name}")
    public List<StudentModel> getStudentByName(@PathVariable String name){
        return studentService.findStudentByName(name);
    }


}
