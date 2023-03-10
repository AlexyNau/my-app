package com.example.api.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 5903583392309472680L;

    private Long id;
    private String lastName;
    private String firstName;
    private String email;
}
