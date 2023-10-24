package com.example.DictionaryApp.repo;

import com.example.DictionaryApp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByUsernameOrEmail(String username, String email);

    UserEntity findByUsername(String username);
}

