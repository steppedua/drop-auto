package com.steppedua.dropauto.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Column(nullable = false)
    private String matchingPassword;
}
