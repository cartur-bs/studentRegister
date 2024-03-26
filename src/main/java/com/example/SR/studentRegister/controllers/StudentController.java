package com.example.SR.studentRegister.controllers;

import com.example.SR.studentRegister.DTOs.StudentDTO;
import com.example.SR.studentRegister.model.StudentModel;
import com.example.SR.studentRegister.repositories.StudentRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRegisterRepository studentRegisterRepository;

    @PostMapping("/postStudent")
    public ResponseEntity<StudentModel> postStudent(@RequestBody StudentDTO studentDTO){
        StudentModel studentRegister = new StudentModel(studentDTO);
        studentRegisterRepository.save(studentRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(path = "/postStudent")
    public ResponseEntity getAllStudents(){
        List<StudentModel> allStudents = studentRegisterRepository.findAll();
        return ResponseEntity.ok(allStudents);
    }

}
