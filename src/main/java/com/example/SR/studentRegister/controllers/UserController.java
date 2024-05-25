package com.example.SR.studentRegister.controllers;

import com.example.SR.studentRegister.DTOs.UserDTO;
import com.example.SR.studentRegister.model.UserModel;
import com.example.SR.studentRegister.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @PostMapping("/postUser")
    public ResponseEntity<?> createProfile(@RequestBody UserDTO userDTO){
        UserModel userModel = new UserModel(userDTO);
        userRepository.save(userModel);
        System.out.println(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}