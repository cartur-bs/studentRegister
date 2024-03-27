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
import java.util.Optional;

@RestController
public class StudentController {
    public final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @Autowired
    StudentRegisterRepository studentRegisterRepository;

    //verifies if there's a student with the studentCode trying to be sent and sends data to DB if false
    @PostMapping("/postStudent")
    public ResponseEntity<?> postStudent(@RequestBody StudentDTO studentDTO){
        boolean studentCodeAvailable = studentService.findStudentByCode(studentDTO.studentCode());
        if(!studentCodeAvailable){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The student code tried is already in use");
        }
        StudentModel studentRegister = new StudentModel(studentDTO);
        studentRegisterRepository.save(studentRegister);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //gets allStudents
    @GetMapping(path = "/getStudent")
    public ResponseEntity getAllStudents(){
        List<StudentModel> allStudents = studentRegisterRepository.findAll();
        return ResponseEntity.ok(allStudents);
    }

    //gets studentByName
    @GetMapping(path = "/student/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name) {
        Optional<StudentModel> studentOptional = studentService.findStudentByName(name);
        if (studentOptional.isPresent()) {
            return ResponseEntity.ok(studentOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with name: " + name);
        }
    }
}
