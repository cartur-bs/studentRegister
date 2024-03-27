package com.example.SR.studentRegister.DTOs;

import java.time.LocalDate;

public record StudentDTO(Integer studentCode, String name,  String course, LocalDate birthDate ) {
}
