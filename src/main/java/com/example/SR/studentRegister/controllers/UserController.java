package com.example.SR.studentRegister.controllers;

import com.example.SR.studentRegister.model.UserModel;
import com.example.SR.studentRegister.repositories.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    public UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> createProfile(UserModel userModel){
        //criar o UserModel com DTO
        userRepository.save(userModel);
    }
}
