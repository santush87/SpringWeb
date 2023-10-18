package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    UserEntity findByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);
}

