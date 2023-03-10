package com.example.api.myapp.service;

import com.example.api.myapp.model.UserEntity;
import com.example.api.myapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements AbstractService<UserEntity, Long, UserRepository> {

    @Getter
    private UserRepository repository;

    public Page<UserEntity> findAllByLastNameAndFirstNameAndEmail(String lastName, String firstName, String email, Pageable pageable) {
        return repository.findAllByLastNameAndFirstNameAndEmail(lastName, firstName, email, pageable);
    }
}
