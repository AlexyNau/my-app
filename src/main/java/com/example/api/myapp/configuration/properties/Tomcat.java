package com.example.api.myapp.configuration.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tomcat {
    private Boolean enableAjp;
    private Integer ajpPort;
}
