package com.example.backendApp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String pin;
    private String newPassword;
    private String confirmPassword;
}
