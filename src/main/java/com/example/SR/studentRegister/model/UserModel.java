package com.example.SR.studentRegister.model;

import com.example.SR.studentRegister.DTOs.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name="TB_USER")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String password;

    public UserModel(UserDTO userDTO) {
        this.userName = userDTO.userName();
        this.password = userDTO.password();
    }

    public UserModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
