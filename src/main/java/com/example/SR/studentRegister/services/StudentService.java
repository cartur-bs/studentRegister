package com.example.SR.studentRegister.services;

import com.example.SR.studentRegister.model.StudentModel;
import com.example.SR.studentRegister.repositories.StudentRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRegisterRepository studentRegisterRepository;
    @Autowired
    StudentService(StudentRegisterRepository studentRegisterRepository){
        this.studentRegisterRepository = studentRegisterRepository;
    }

    public List<StudentModel> findStudentByName(String name){
        return studentRegisterRepository.findByName(name);

    }
}
