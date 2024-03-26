package com.example.SR.studentRegister.repositories;

import com.example.SR.studentRegister.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegisterRepository extends JpaRepository<StudentModel, String> {
}
