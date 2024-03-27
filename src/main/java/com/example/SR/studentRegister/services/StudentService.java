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

    public Optional<StudentModel> findStudentByName(String name) {
        StudentModel student = studentRegisterRepository.findByName(name);
        if (student == null) {
            throw new EntityNotFoundException("Estudante com o nome '" + name + "' não encontrado.");
        }
        return Optional.of(student);
    }
}
