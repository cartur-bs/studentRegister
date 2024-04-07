package com.example.SR.studentRegister.services;

import com.example.SR.studentRegister.model.UserModel;
import com.example.SR.studentRegister.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public Optional<UserModel> getUserByUsername(String username){
       // userRepository.
    }*/
}
