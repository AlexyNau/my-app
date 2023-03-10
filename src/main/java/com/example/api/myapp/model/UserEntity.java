package com.example.api.myapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
@Getter
@Setter
@ToString
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name= "last_name", nullable = false)
    private String lastName;
    @Column(name= "first_name", nullable = false)
    private String firstName;
    @Column(name= "email", nullable = false)
    private String email;
}
