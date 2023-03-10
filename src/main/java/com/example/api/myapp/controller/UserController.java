package com.example.api.myapp.controller;

import com.example.api.myapp.api.UserApi;
import com.example.api.myapp.dto.User;
import com.example.api.myapp.mapper.UserMapper;
import com.example.api.myapp.model.UserEntity;
import com.example.api.myapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController implements UserApi {
    @Autowired
    private UserService userService;
    private UserMapper userMapper;

    @Override
    public ResponseEntity<Page<User>> listUser(String lastName, String firstName, String email, Pageable pageable) {

        Page<UserEntity> userEntities = userService.findAllByLastNameAndFirstNameAndEmail(lastName, firstName, email, pageable);

        Page<User> users = userEntities.map(entity -> userMapper.userEntityToUser(entity));

        return ResponseEntity.ok(users);
    }
}
