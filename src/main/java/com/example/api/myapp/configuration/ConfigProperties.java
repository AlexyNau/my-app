package com.example.api.myapp.configuration;

import com.example.api.myapp.configuration.properties.Tomcat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Getter
@Setter
@ConfigurationProperties(prefix = "api")
@ConfigurationPropertiesScan
public class ConfigProperties {

    private Tomcat tomcat;
}
