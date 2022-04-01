package com.example.photo.Entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String role;
}
