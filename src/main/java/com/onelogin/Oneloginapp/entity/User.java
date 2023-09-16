package com.onelogin.Oneloginapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(nullable = true)
    private String phone_number;
    private String password;
    @Column(nullable = true)
    private int gender;
    @Column(nullable = true)
    private String pid;
    @Column(nullable = true)
    private String designation;
    @Column(nullable = true)
    private String remember_token;
    @Column(nullable = true)
    private String created_at;
    @Column(nullable = true)
    private String updated_at;
}
