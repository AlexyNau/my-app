package com.example.api.myapp.configuration;

import org.mapstruct.MapperConfig;

@MapperConfig(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface MapStructDefaultConfig {

}