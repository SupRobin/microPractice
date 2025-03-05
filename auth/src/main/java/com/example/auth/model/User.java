package com.example.auth.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @NotBlank(message = "first name cannot be blank")
    @Column(nullable = false)
    String firstName;

    @NotBlank(message = "last name cannot be blank")
    @Column(nullable = false)
    String lastName;

    @NotBlank(message = "email is mandatory")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    String email;

    @NotBlank(message = "username is mandatory")
    @Column(nullable = false, unique = true)
    String username;

    @NotBlank(message = "password is mandatory")
    @Column(nullable = false)
    String password;


}
