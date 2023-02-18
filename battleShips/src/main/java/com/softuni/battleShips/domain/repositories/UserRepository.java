package com.softuni.battleShips.domain.repositories;

import com.softuni.battleShips.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

    @Override
    Optional<User> findById(String id);

    Optional<User> findByIdNot(String id);
}

