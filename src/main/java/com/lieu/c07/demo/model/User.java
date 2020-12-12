package com.lieu.c07.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(50) default 'codeGym' ")
    private String fullName;

    private String phone;

    private String address;
    private Long age;
    private String email;
    private Boolean status;

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

}
