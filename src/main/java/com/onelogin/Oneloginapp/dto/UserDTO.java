package com.onelogin.Oneloginapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int id;
    private String name;
    private String phone_number;
    private String password;
    private int gender;
    private String pid;
    private String designation;
    private String remember_token;
    private String created_at;
    private String updated_at;
}
