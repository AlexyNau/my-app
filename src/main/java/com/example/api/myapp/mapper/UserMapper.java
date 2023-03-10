package com.example.api.myapp.mapper;

import com.example.api.myapp.configuration.MapStructDefaultConfig;
import com.example.api.myapp.dto.User;
import com.example.api.myapp.model.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructDefaultConfig.class)
public interface UserMapper extends AbstractMapper<List<UserEntity>, List<User>>{

    List<User> toDTO(List<UserEntity> userEntities);

    User userEntityToUser(UserEntity userEntity);
}
