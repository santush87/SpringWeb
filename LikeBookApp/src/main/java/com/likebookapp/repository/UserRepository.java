package com.likebookapp.repository;

import com.likebookapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    boolean existsByUsernameOrEmail(String username, String email);

    UserEntity findByUsername(String username);
}
