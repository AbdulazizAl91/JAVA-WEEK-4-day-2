package com.example.usystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name should be not empty")
    @Size(min =4,max = 25,message = "name should be between 4 and 25")
    @Column(columnDefinition = "varchar(25) not null")
    private String name;
    @NotEmpty(message = "username should be not empty")
    @Size(min = 4,max = 25,message = "username should be between 4 and 25")
    @Column(columnDefinition = "varchar(25) unique not null")

    private String username;
    @NotEmpty(message = "password should be not empty")
    @Column(columnDefinition = "varchar(25) not null ")
    private String password;
    @Email
    @NotEmpty(message = "email should be not empty")
    @Column(unique = true, columnDefinition = "varchar(40) unique not null ")
    private String email;
    @NotEmpty(message = "role should be not empty")
    @Pattern(regexp = "admin|user",message = "role should be admin or user")
    @Column(columnDefinition = "varchar(5) not null check(role in ('admin','user'))")
    private String role;
    @Positive
    @NotNull(message = "age should not null")
    @Column(columnDefinition = "int not null")
    private Integer age;

}
