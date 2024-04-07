package com.example.SR.studentRegister.repositories;

import com.example.SR.studentRegister.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
