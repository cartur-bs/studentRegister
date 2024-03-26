package com.example.SR.studentRegister.DTOs;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

public record StudentDTO( String name,  String course, LocalDate birthDate ) {
}
