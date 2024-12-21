package com.gdgoc.Online_Library.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Password is required")
    private String password;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    private String email;
}
