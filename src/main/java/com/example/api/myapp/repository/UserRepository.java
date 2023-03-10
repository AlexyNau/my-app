package com.example.api.myapp.repository;

import com.example.api.myapp.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<UserEntity, Long> {

    @Override
    default Class<UserEntity> getPersistentClass() {
        return UserEntity.class;
    }

    @Query("SELECT user FROM #{#entityName} user WHERE " +
            "(:lastName is NULL OR UPPER(user.lastName) LIKE UPPER('%'||:lastName||'%')) " +
            "AND (:firstName is NULL OR UPPER(user.firstName) LIKE UPPER('%'||:firstName||'%')) " +
            "AND (:email is NULL OR UPPER(user.email) LIKE UPPER('%'||:email||'%')) ")
    Page<UserEntity> findAllByLastNameAndFirstNameAndEmail(String lastName, String firstName, String email, Pageable pageable);
}
