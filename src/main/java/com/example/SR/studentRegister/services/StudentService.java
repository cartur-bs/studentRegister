package com.example.SR.studentRegister.services;

import com.example.SR.studentRegister.model.StudentModel;
import com.example.SR.studentRegister.repositories.StudentRegisterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final StudentRegisterRepository studentRegisterRepository;
    @Autowired
    StudentService(StudentRegisterRepository studentRegisterRepository){
        this.studentRegisterRepository = studentRegisterRepository;
    }

    //helper to verify is there's valid data with the desired name
    public Optional<StudentModel> findStudentByName(String name) {
        StudentModel student = studentRegisterRepository.findByName(name);
        if (student == null) {
            return Optional.empty();
        }
        return Optional.of(student);
    }

    //helper to verify is there's already a studentCode equals the one being created
    public boolean findStudentByCode(int code){
        StudentModel studentModel = studentRegisterRepository.findByStudentCode(code);
        if(studentModel != null){
            return false;
        }
        return true;
    }
}
